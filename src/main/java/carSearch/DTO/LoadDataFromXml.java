package carSearch.DTO;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import carSearch.model.Car;
import carSearch.model.Location;
import carSearch.model.Price;

public class LoadDataFromXml {

	 private Element locationsRoot;
	 private Element pricesRoot;
	 private Element carsRoot;
	 
	 private void setLocationsRoot(Element locations) 
	 {
		 this.locationsRoot = locations;
	 }
	 
	 private Element getLocationsRoot()
	 {
		return this.locationsRoot;
	 }
	 
	 private void setPricesRoot(Element prices) 
	 {
		 this.pricesRoot = prices;
	 }
	 
	 private Element getPricesRoot()
	 {
		return this.pricesRoot;
	 }
	 
	 private void setCarsRoot(Element cars) 
	 {
		 this.carsRoot = cars;
	 }
	 
	 private Element getCarsRoot()
	 {
		return this.carsRoot;
	 }
	 
	 
	 public LoadDataFromXml()
	 {
		 SAXBuilder builder = new SAXBuilder();
		    File xmlFile = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\wtpwebapps\\CarDealsFinder\\WEB-INF\\classes\\xml\\AutoEurope.xml");//new File(getClass().getResource("/xml/AutoEurope.xml").getFile());	
			/*File xmlFile =  new File(LoadDataFromXml.class.getClassLoader().getResource("xml/AutoEurope.xml").getFile()); //new FileSystemResource("classpath:/xml/AutoEurope.xml").getFile();
			ServletContext ctx = Application.Context();
			InputStream configStream = ctx.getResourceAsStream("/WEB-INF/config.properties");*/
			try {

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			setLocationsRoot(rootNode.getChild("Locations"));
			setPricesRoot(rootNode.getChild("Prices"));
			setCarsRoot(rootNode.getChild("Cars"));
			
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
	 }
	
	 public List<Location> parseLocationXML() 
	   { 
			List<Location> locations = new ArrayList<Location>();
			List locationsXML = getLocationsRoot().getChildren("Location");		     
		    for (int i = 0; i < locationsXML.size(); i++) {

				   Element node = (Element) locationsXML.get(i);
				   Location location = new Location(Integer.parseInt(node.getChildText("id")),node.getChildText("name"));
			       locations.add(location);
		      	  } 
	      return locations;
		
	   }
	 
	 public List<Car> parseCarsXML() 
	   { 
			List<Car> cars = new ArrayList<Car>();
			List carsXML = getCarsRoot().getChildren("Car");		     
		    for (int i = 0; i < carsXML.size(); i++) {

				   Element node = (Element) carsXML.get(i);
				   Car car = new Car(Integer.parseInt(node.getChildText("id")),node.getChildText("model"));
				   cars.add(car);
		      	  } 
	      return cars;
		
	   }
	 
	 public List<Price> parsePricesXML()
	 {
		 List<Price> prices = new ArrayList<Price>();
			List pricesXML = getPricesRoot().getChildren("Price");		     
		    for (int i = 0; i < pricesXML.size(); i++) {

				   Element node = (Element) pricesXML.get(i);
				   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			       Date date = null;
				try {
					date = formatter.parse(node.getChildText("date"));
				} catch (ParseException e) {
				}
			       Price  price = new Price(Integer.parseInt(node.getChildText("carId")),Integer.parseInt(node.getChildText("locationId")),date,Integer.parseInt(node.getChildText("quote")));
			      
				   prices.add(price);
		      	  } 
	      return prices; 	 
	 }
	 
	 

	}
