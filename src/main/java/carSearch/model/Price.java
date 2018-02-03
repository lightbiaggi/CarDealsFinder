package carSearch.model;

import java.io.Serializable;
import java.util.Date;
public class Price implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer carId;
	private Integer locationId;
	private Date selectedDate;
	private Integer dailyQuote;
		
	public Price(Integer carId, Integer locationId,Date selectedDate,Integer dailyQuote) {
		this.carId = carId;
		this.locationId = locationId;
		this.selectedDate = selectedDate;
		this.dailyQuote = dailyQuote;
	}
	
	public void setCarId(Integer carId)
	{
		this.carId = carId;
	}
	
	public Integer getCarId()
	{
		return this.carId;
	}
	
	public void setLocationId(Integer locationId)
	{
		this.locationId = locationId;
	}
	
	public Integer getLocationId()
	{
		return this.locationId;
	}
	
	public void setDailyQuote(Integer dailyQuote)
	{
		this.dailyQuote = dailyQuote;
	}
	
	public Integer getDailyQuote()
	{
		return this.dailyQuote;
	}
	
	public void setSelectedDate(Date selectedDate)
	{
		this.selectedDate = selectedDate;
	}
	
	public Date getSelectedDate()
	{
		return this.selectedDate;
	}
/*List<Triplet<Integer,Date,Integer>> quotes = new ArrayList<Triplet<Integer, Date,Integer>>();

public void SetQuotes(List<Triplet<Integer,Date,Integer>> quotes)
{
	this.quotes = quotes;
}

public List<Triplet<Integer,Date,Integer>> GetQuotes(){
	return this.quotes;
}*/

}
