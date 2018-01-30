package pl.lukaszbudyn.wakemyapp.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;


import javax.validation.Constraint;

@Constraint(validatedBy = HoursStartSmallerThanStopValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface HoursStartSmallerThanStop {
	
	String message() default "Start hour must be smaller than stop hour!";
	String startHour();
	String stopHour();
	
	Class<?>[] groups() default {};
	Class<?>[] payload() default {};
	
//	@Target({ ElementType.TYPE })
//	@Retention(RetentionPolicy.RUNTIME)
//	@interface List {
//		HoursStartSmallerThanStop[] value();
//		}
}
