package carSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import carSearch.dao.LocationDAO;
import carSearch.model.Location;

public class LocationManager implements ILocationManager {

	 private LocationDAO dao;
	
	public LocationManager() {
		dao = new LocationDAO();
		
	}

	public List<Location> GetAllLocations() {
		return  dao.GetAllLocations();
	}

}
