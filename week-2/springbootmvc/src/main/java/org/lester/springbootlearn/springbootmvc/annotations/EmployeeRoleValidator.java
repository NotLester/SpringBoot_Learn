package org.lester.springbootlearn.springbootmvc.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.equals("ADMIN") || value.equals("USER"));
    }
}
