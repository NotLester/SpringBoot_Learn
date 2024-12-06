package org.lester.springbootlearn.homework1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subject extends BaseEntity {
    @Column(nullable = false)
    private String title;
}
