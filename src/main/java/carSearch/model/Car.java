package carSearch.model;

import java.io.Serializable;
public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private Integer id;
	private String model;
	
	public Car(Integer id, String model) {
		this.id = id;
		this.model = model;
	}
	
	public void setId(Integer Id)
	{
		this.id = Id;
	}
	
	public Integer getId()
	{
		return this.id;
	}

	public void setModel(String Model)
	{
		this.model = Model;
	}
	
	public String getModel()
	{
		return this.model;
	}
	


}
