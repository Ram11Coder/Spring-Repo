package com.batch.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.RowMapper;

import com.batch.entity.Customer;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	private JobBuilderFactory jobBuilderFactory;

	private StepBuilderFactory stepBuilderFactory;

	private DataSource datasource;

//	private CustomerRepository customerRepository;

	@Bean
	public JdbcCursorItemReader<Customer> reader() {
		JdbcCursorItemReader<Customer> itemReader = new JdbcCursorItemReader<>();

		itemReader.setDataSource(datasource);
		itemReader.setSql(
				"select customer_id,first_name,last_name, email,  gender,contact, country, dob from CUSTOMERS_INFO");
		itemReader.setRowMapper(new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setGender(rs.getString("gender"));
				customer.setContactNo(rs.getString("contact"));
				customer.setCountry(rs.getString("country"));
				customer.setDob(rs.getString("dob"));

				return customer;
			}
		});
		return itemReader;
	}
	/*
	 * private LineMapper<Customer> lineMapper() { DefaultLineMapper<Customer>
	 * lineMapper = new DefaultLineMapper<>();
	 * 
	 * DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	 * lineTokenizer.setDelimiter(","); lineTokenizer.setStrict(false);
	 * lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender",
	 * "contactNo", "country", "dob");
	 * 
	 * BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new
	 * BeanWrapperFieldSetMapper<>(); fieldSetMapper.setTargetType(Customer.class);
	 * 
	 * lineMapper.setLineTokenizer(lineTokenizer);
	 * lineMapper.setFieldSetMapper(fieldSetMapper); return lineMapper;
	 * 
	 * }
	 */

	/*
	 * @Bean public CustomerProcessor processor() { return new CustomerProcessor();
	 * }
	 */

	@Bean
	public FlatFileItemWriter<Customer> writer() {
		FlatFileItemWriter<Customer> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("D:\\spring\\spring-batch\\customer.csv"));
		DelimitedLineAggregator<Customer> aggregator = new DelimitedLineAggregator<>();
		BeanWrapperFieldExtractor<Customer> fieldExtractor = new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(
				new String[] { "id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob" });
		aggregator.setFieldExtractor(fieldExtractor);
		writer.setLineAggregator(aggregator);
		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step").<Customer, Customer>chunk(10).reader(reader()).writer(writer())
				/* .taskExecutor(taskExecutor()) */.build();
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importCustomers").incrementer(new RunIdIncrementer()).flow(step1()).end().build();

	}

	/*
	 * @Bean public TaskExecutor taskExecutor() { SimpleAsyncTaskExecutor
	 * asyncTaskExecutor = new SimpleAsyncTaskExecutor();
	 * asyncTaskExecutor.setConcurrencyLimit(10); return asyncTaskExecutor; }
	 */

}
