package com.spring.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.spring.web.validation.Impl.UsernameValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ElementType.TYPE,ElementType.PARAMETER , ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy =  UsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameValid {
	String message() default "Username not valid";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
