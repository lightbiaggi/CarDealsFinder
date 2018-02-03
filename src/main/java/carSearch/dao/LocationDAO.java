package carSearch.dao;

import java.io.File;
import java.util.List;
import carSearch.model.Location;

public class LocationDAO extends BaseDAO implements ILocationDAO {
	
	public LocationDAO(File xmlFile) {
		super(xmlFile);
	}

	public List<Location> GetAllLocations() {
		 return xmlLoader.parseLocationXML();
	}

}
