package carSearch.dao;

import java.io.File;

import carSearch.DTO.LoadDataFromXml;

public class BaseDAO {

	protected LoadDataFromXml xmlLoader;

	public BaseDAO()
	{
		
	}
	
	public BaseDAO(File xmlFile) {
		xmlLoader =  new LoadDataFromXml(xmlFile);
	}

}