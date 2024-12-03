package org.lester.springbootlearn.springbootmvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.lester.springbootlearn.springbootmvc.annotations.EmployeeRoleValidation;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 60, message = "Age should not be greater than 60")
    private Integer age;

    @NotBlank(message = "Role cannot be empty")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role should be either ADMIN or USER")
    @EmployeeRoleValidation
    private String role; //ADMIN, USER

    @PastOrPresent(message = "Date of joining should be in the past or present")
    @JsonProperty("dateOfJoining")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
