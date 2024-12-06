package org.lester.springbootlearn.homework1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AdmissionRecord extends BaseEntity {
    @Column(nullable = false)
    private Integer fees;

    @OneToOne
    @JoinColumn(name = "admitted_student")
    private Student student;
}
