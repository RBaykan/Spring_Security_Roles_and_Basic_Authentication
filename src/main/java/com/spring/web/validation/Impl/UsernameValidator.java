package com.spring.web.validation.Impl;

import java.util.Arrays;

import org.passay.AllowedRegexRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

import com.spring.web.validation.UsernameValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UsernameValidator implements ConstraintValidator<UsernameValid, String> {

	
	    
	    private static final PasswordValidator validator = new PasswordValidator(Arrays.asList(
	    		
	    		new LengthRule(3, 15),
	    		new CharacterRule(EnglishCharacterData.Alphabetical),
	    		new WhitespaceRule(),
	    		new AllowedRegexRule("^[\\p{ASCII}]*$")
				
				));
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
				
		RuleResult result = validator.validate(new PasswordData(value));
		return result.isValid();
		
	}
	


}
