package br.com.eduardonunesdev.educafacil.services.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
Username deve conter apenas caracteres minúsculos, sem numerais e sem espaços.
Precisa ser um endereço de e-mail em um formato válido.
Pode apenas ter um usuário com o mesmo email/username.

*/
public class UsernameValidator implements ConstraintValidator<UsernameValid, String> {
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username.matches("^[a-z]*$");
    }
}
