package org.lester.springbootlearn.homework1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Student extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;
}
