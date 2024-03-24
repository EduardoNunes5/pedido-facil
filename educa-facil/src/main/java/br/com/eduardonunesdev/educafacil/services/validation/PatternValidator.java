package br.com.eduardonunesdev.educafacil.services.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;

public class PatternValidator implements ConstraintValidator<ValidPattern, String> {

    private String pattern;
    @Override
    public void initialize(ValidPattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

        return username.matches(pattern);
    }
}
