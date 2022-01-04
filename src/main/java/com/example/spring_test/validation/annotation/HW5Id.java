package com.example.spring_test.validation.annotation;

import com.example.spring_test.validation.validator.HW5IdValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { HW5IdValidator.class })
public @interface HW5Id {
    String message() default "身分證錯誤"; // 預設驗證錯誤訊息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
