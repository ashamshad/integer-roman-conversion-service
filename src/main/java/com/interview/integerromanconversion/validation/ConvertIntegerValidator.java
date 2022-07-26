package com.interview.integerromanconversion.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ConvertIntegerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Integer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
