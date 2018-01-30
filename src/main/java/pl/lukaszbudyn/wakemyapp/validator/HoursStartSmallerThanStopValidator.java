package pl.lukaszbudyn.wakemyapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class HoursStartSmallerThanStopValidator 
	implements ConstraintValidator<HoursStartSmallerThanStop, Object>{

	private String startHour;
	private String stopHour;
	private String errorMessage = "Start hour must be smaller than stop hour";
	
	@Override
	public void initialize(HoursStartSmallerThanStop constraintAnnotation) {
		this.startHour = constraintAnnotation.startHour();
		this.stopHour = constraintAnnotation.stopHour();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object startHourValue = new BeanWrapperImpl(value).getPropertyValue(startHour);
		Object stopHourValue = new BeanWrapperImpl(value).getPropertyValue(stopHour);
		int startHourValueInt = (int) startHourValue;
		int stopHourValueInt = (int) stopHourValue;
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(errorMessage)
			.addPropertyNode(startHour).addConstraintViolation();
		return startHourValueInt<stopHourValueInt;
	}

}
