package carSearch.service;

import java.util.Date;
import java.util.List;

import carSearch.dao.PriceDAO;
import carSearch.model.Price;

public class PriceManager implements IPriceManager {

	private PriceDAO dao;
	public PriceManager() {
		dao =  new PriceDAO();
	}

	public List<Price> GetPriceForLocationAndDate(Integer locationId, Date selectedDate) {
		// TODO Auto-generated method stub
		return dao.GetPriceForLocationAndDate(locationId, selectedDate);
	}

}
