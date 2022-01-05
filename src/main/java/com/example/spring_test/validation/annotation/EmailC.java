package com.example.spring_test.validation.annotation;

import com.example.spring_test.validation.validator.EmailCValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { EmailCValidator.class })
public @interface EmailC {
    String message() default "信箱格式錯誤"; // 預設驗證錯誤訊息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
