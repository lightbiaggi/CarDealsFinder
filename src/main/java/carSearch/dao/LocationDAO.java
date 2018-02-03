package carSearch.dao;

import java.util.List;
import carSearch.model.Location;

public class LocationDAO extends BaseDAO implements ILocationDAO {
	
	public List<Location> GetAllLocations() {
		 return xmlLoader.parseLocationXML();
	}

}
