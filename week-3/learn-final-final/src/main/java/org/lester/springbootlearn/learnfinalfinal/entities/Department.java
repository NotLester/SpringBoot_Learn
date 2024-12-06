package org.lester.springbootlearn.learnfinalfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Department extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "dept_manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getManager(), that.getManager());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}