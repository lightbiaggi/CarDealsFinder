package carSearch.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import carSearch.model.CarSearch;
public class CarSearchValidator {

	public boolean supports(Class clazz) {
		return CarSearch.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "selectedDate", "error.selectedDate", "Date is required");
		ValidationUtils.rejectIfEmpty(errors, "location", "error.location", "location is required");
	}
}
