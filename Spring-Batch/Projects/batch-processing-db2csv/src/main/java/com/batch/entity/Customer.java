package com.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private String gender;

	private String contactNo;

	private String country;

	private String dob;

}
