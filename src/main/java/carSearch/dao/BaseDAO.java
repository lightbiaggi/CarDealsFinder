package carSearch.dao;

import carSearch.DTO.LoadDataFromXml;

public class BaseDAO {

	protected LoadDataFromXml xmlLoader;

	public BaseDAO() {
		super();
		xmlLoader =  new LoadDataFromXml();
	}

}