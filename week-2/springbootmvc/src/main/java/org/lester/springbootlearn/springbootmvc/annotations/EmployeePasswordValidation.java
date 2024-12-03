package org.lester.springbootlearn.springbootmvc.annotations;


import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface EmployeePasswordValidation {
    String message() default "Password must contain one uppercase, one lowercase, one special character with minimum length of 10";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
