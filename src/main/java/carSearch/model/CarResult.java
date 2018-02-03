package carSearch.model;

import java.io.Serializable;

public class CarResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String model;
	private Integer price;
	
	public CarResult( String model, Integer price) {
		this.model = model;
		this.price = price;
	}
	

	public void setModel(String model)
	{
		this.model = model;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public void setPrice(Integer price)
	{
		this.price = price;
	}
	
	public Integer getPrice()
	{
		return this.price;
	}
}
