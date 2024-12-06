package org.lester.springbootlearn.learnfinalfinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;
}
