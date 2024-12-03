package org.lester.springbootlearn.springbootmvc.annotations;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface EmployeeRoleValidation {
    String message() default "Role should be either ADMIN or USER";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
