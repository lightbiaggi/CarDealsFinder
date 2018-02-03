package carSearch.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import carSearch.dao.CarDAO;
import carSearch.model.Car;
import carSearch.model.CarResult;
import carSearch.model.Price;

public class CarManager implements ICarManager {
private CarDAO dao;
	
	public CarManager(File xmlFile) {
		dao = new CarDAO(xmlFile);
	}

	public List<Car> GetCarsInventory() {
		return dao.GetCarsInventory();
	}
	
	public List<CarResult> GetCheaptestCars(List<Price> bestDeals, Integer price)
	{
		List<Car> cars = this.GetCarsInventory();
		List<CarResult> cheapestCars = new ArrayList<CarResult>(); 
		
		for(Car c:cars)
		{
			 boolean carExists = bestDeals.stream()
			            .anyMatch(t -> t.getCarId().equals(c.getId()));
			 
			 if(carExists)
				 {
				 CarResult car = new CarResult(c.getModel(),price);
				 cheapestCars.add(car);
				 }
			
		}
		
		return cheapestCars;
	}

}
