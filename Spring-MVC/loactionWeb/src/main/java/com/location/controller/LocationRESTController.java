package com.location.controller;

import java.util.Collections;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.entity.Location;
import com.location.repo.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	LocationRepository repo;

	@GetMapping
	public List<Location> getLocations() {
		return repo.findAll();
	}

//@RequestBody  converts the json request into Location Object

	@PostMapping
	public Location saveLocation(@RequestBody Location location) {
		return repo.save(location);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return repo.save(location);
	}

	/*
	 * @DeleteMapping public void deleteLocation(@RequestBody Location location) {
	 * repo.deleteById(location.getId()); }
	 */
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

	@GetMapping("/{id}")
	public Location getLocation(@PathVariable int id) {

		return repo.findById(id).orElse(new Location());
	}

}
