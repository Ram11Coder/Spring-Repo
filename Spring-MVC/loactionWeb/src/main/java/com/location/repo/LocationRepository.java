package com.location.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.entity.Location;

/**
 * USe JpaRespository instead of CrudRepository if required
 * 
 * @author thula
 *
 */
//public interface LocationRepository extends CrudRepository<Location, Integer> {
public interface LocationRepository extends JpaRepository<Location, Integer> {

	@Query("select type,count(type) from Location group by type")
	public List<Object[]> findTypeAndTypeCount();

}
