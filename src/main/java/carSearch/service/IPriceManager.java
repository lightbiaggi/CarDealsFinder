package carSearch.service;

import java.util.Date;
import java.util.List;

import carSearch.model.Price;

public interface IPriceManager {
	public List<Price> GetPriceForLocationAndDate(Integer locationId, Date selectedDate);
}
