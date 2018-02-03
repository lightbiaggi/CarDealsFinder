package carSearch.dao;

import java.util.Date;
import java.util.List;

import carSearch.model.Price;

public interface IPriceDAO {
	public List<Price> GetPriceForLocationAndDate(Integer locationId, Date selectedDate);

}
