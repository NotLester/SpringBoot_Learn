package org.lester.springbootlearn.springbootmvc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String role;

    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;

    @Column(name = "is_active")
    private Boolean isActive;
}
