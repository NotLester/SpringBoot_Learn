package org.lester.springbootlearn.springbootmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "is_active")
    Boolean isActive;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
