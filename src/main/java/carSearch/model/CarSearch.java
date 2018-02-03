package carSearch.model;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class CarSearch implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -5294294793605678955L;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date selectedDate;
	@NotNull
	private Location location;

	
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getSelectedDate() {
		return this.selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	
}
