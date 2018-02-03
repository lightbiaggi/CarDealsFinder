package carSearch.editors;

import java.beans.PropertyEditorSupport;

import carSearch.model.Location;

public class LocationEditor extends PropertyEditorSupport  {

	@Override
    public void setAsText(String id) 
    {
    	Location d;
    	switch(Integer.parseInt(id))
		{
			case 1: d = new Location(1,  "Fiumicino"); break;
			case 2: d = new Location(2,  "Rome"); break;
			case 3: d = new Location(3,  "Arlanda"); break;
			case 4: d = new Location(3,  "Franz Josef Strauss"); break;
			default: d = null;
		}
        this.setValue(d);
    }

}
