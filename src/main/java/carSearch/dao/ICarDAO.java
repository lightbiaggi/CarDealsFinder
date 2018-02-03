package carSearch.dao;

import java.util.List;

import carSearch.model.Car;

public interface ICarDAO {
	public List<Car> GetCarsInventory();
}
