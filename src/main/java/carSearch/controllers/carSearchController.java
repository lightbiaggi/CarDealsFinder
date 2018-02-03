package carSearch.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import carSearch.editors.LocationEditor;
import carSearch.model.Car;
import carSearch.model.CarResult;
import carSearch.model.CarSearch;
import carSearch.model.Location;
import carSearch.model.Price;
import carSearch.service.CarManager;
import carSearch.service.ICarManager;
import carSearch.service.ILocationManager;
import carSearch.service.IPriceManager;
import carSearch.service.LocationManager;
import carSearch.service.PriceManager;

@Controller
@RequestMapping("/locateCar")
@SessionAttributes("carSearch")
public class carSearchController {
	
	private ILocationManager locationManager;
	private ICarManager carManager;
	private IPriceManager priceManager;
	private Validator validator;

	public carSearchController()
	{
	//	ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
	//	validator = validatorFactory.getValidator();
		locationManager =  new LocationManager();
		carManager =  new CarManager();
		priceManager = new PriceManager();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Location.class, new LocationEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("mm-dd-yyyy"), true));
    }
	
	@ModelAttribute("allLocations")
    public List<Location> populateLocations() 
    {
        List<Location> loc = locationManager.GetAllLocations();
      return loc; 
    }

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		CarSearch carSearch = new CarSearch();
		model.addAttribute("carSearch", carSearch);
		return "locateCar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("carSearch") CarSearch carSearch,
			RedirectAttributes redir,BindingResult result, SessionStatus status) {

		Set<ConstraintViolation<CarSearch>> violations = validator.validate(carSearch);
		
		for (ConstraintViolation<CarSearch> violation : violations) 
		{
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("locateCar", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }

		if (result.hasErrors()) {
			return "locateCar";
		}
	
		// get all cars with quotes for that location
		List<Price> prices =  priceManager.GetPriceForLocationAndDate(carSearch.getLocation().getId(), carSearch.getSelectedDate());
		
		// get min price for that location	
		Price lowestFair = prices.stream()
                  .min((p1, p2) -> Integer.compare(p1.getDailyQuote(), p2.getDailyQuote()))
                  .get();
		
		// Find all cars that matches that
		List<Price> bestDeals = prices.stream()
					.filter(x->x.getDailyQuote() == lowestFair.getDailyQuote())
					.collect(Collectors.toList());
		
		// Mark Session Complete
				status.setComplete();
		
		// get the list of the cars to display with that price and pass it to the result page
		redir.addFlashAttribute("cheapestCars", carManager.GetCheaptestCars(bestDeals, lowestFair.getDailyQuote()));
		return "redirect:locateCar/success";
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success(Model model) {
		return "searchResult";
	}
}

