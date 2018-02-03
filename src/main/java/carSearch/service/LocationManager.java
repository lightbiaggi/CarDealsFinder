package carSearch.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import carSearch.dao.LocationDAO;
import carSearch.model.Location;

public class LocationManager implements ILocationManager {

	 private LocationDAO dao;
	
	public LocationManager(File xmlFile) {
		dao = new LocationDAO(xmlFile);		
	}

	public List<Location> GetAllLocations() {
		return  dao.GetAllLocations();
	}

}
