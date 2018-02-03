package carSearch.dao;

import java.util.List;
import carSearch.model.Car;

public class CarDAO extends BaseDAO implements ICarDAO  {

	public List<Car> GetCarsInventory() {
		// TODO Auto-generated method stub
		return xmlLoader.parseCarsXML();
	}

}
