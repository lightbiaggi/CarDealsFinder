package carSearch.service;

import java.util.List;

import carSearch.model.Car;
import carSearch.model.CarResult;
import carSearch.model.Price;

public interface ICarManager {
	public List<Car> GetCarsInventory();
	public List<CarResult> GetCheaptestCars(List<Price> bestDeals, Integer price);
}


