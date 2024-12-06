package org.lester.springbootlearn.homework1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Professor extends BaseEntity {
    @Column(nullable = false)
    private String title;
}
