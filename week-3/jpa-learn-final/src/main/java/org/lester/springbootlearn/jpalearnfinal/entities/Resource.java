package org.lester.springbootlearn.jpalearnfinal.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Resource extends BaseEntity {

    private String name;

    private String url;

    private int size;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
