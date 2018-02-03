package carSearch.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import carSearch.model.Price;

public class PriceDAO extends BaseDAO implements IPriceDAO {

	public List<Price> GetPriceForLocationAndDate(Integer locationId, Date selectedDate) {
	List<Price> locationPrices = new ArrayList<Price>();
	
	for(Price p:xmlLoader.parsePricesXML())
	{
		if(p.getLocationId() == locationId && p.getSelectedDate().compareTo(new Date()) >= 0) locationPrices.add(p);
		//if(p.getLocationId() == locationId) locationPrices.add(p);
	}
	
	return locationPrices;
	}

}
