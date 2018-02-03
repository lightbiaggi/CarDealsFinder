package carSearch.dao;

import java.io.File;
import java.util.List;
import carSearch.model.Car;

public class CarDAO extends BaseDAO implements ICarDAO  {

	public CarDAO(File xmlFile) {
		super(xmlFile);
	}

	public List<Car> GetCarsInventory() {
		return xmlLoader.parseCarsXML();
	}

}
