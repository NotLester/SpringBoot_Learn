package org.lester.springbootlearn.springbootmvc.annotations;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface PrimeNumberValidation {
    String message() default "Number should be a prime number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
