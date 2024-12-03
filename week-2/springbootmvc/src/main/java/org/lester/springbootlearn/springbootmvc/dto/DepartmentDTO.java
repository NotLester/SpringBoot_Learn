package org.lester.springbootlearn.springbootmvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotNull(message = "isActive cannot be null")
    @AssertTrue(message = "Department should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull(message = "createdAt cannot be null")
    @PastOrPresent(message = "Date of creation should be in the past or present")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
}
