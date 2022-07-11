package com.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.entity.Location;
import com.location.repo.LocationRepository;
import com.location.service.LocationService;
import com.location.util.EmailUtil;
import com.location.util.ReportUtil;

@Controller
public class LocationController {
	@Autowired
	private LocationService locationService;
	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	LocationRepository locrepo;
	
	@Autowired
	private ReportUtil report;

	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showLocation")
	// @GetMapping("/showLocation")
	public String showLocation() {
		return "CreateLocation";
	}

	@RequestMapping("/savelocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location savedLocation = locationService.saveLocation(location);
		String message = "Location saved with id " + savedLocation.getId();
		modelMap.addAttribute("msg", message);

		emailUtil.sendMail("springtestemail49@gmail.com", "Save Location", message);
		return "CreateLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayAllLocations(ModelMap modelMap) {
		List<Location> allLocations = locationService.getAllLocation();
		modelMap.addAttribute("locations", allLocations);

		return "displayLocations";
	}

	@RequestMapping("deleteLocation")
	public String deleteLoc(@RequestParam("id") int id, ModelMap modalMap) {
		Location location = locationService.getLocationById(id);
		/**
		 * or use below approach
		 * 
		 * Location location =new Location();
		 * 
		 * location.setId(id);
		 * 
		 */

		locationService.deleteLocation(location);

		List<Location> allLocations = locationService.getAllLocation();
		modalMap.addAttribute("locations", allLocations);
		return "displayLocations";

	}

	@RequestMapping("/showUpdate")
	public String editLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);

		modelMap.addAttribute("location", location);
		return "editLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {

		
		String path=sc.getRealPath("/");
		
		List<Object[]> dataset = locrepo.findTypeAndTypeCount();
		
		report.generatePieChart(path, dataset);
		return "report";
	}
}
