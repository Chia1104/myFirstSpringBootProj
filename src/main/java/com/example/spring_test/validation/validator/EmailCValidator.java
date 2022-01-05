package com.example.spring_test.validation.validator;

import com.example.spring_test.validation.annotation.EmailC;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailCValidator implements ConstraintValidator<EmailC, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        // Email格式正則表示式
        String regex = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$";
        boolean isValid = Pattern.compile(regex).matcher(email).find();
        return isValid;
    }
}
