package org.lester.springbootlearn.jpalearnfinal.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

//@Table(name = "AUTHOR_TBL")

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Author extends BaseEntity {
//    @Id
//    @GeneratedValue
//    @GeneratedValue(
//            strategy = GenerationType.TABLE,
//            generator = "author_id_generator"
//    )
    /*@TableGenerator(
            name = "author_id_generator",
            table = "author_id_generator",
            pkColumnName = "author_id",
            valueColumnName = "author_value",
            allocationSize = 1
    )*/
    /*@SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )*/
//    private Integer id;

    @Column(name = "f_name", length = 35)
    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private Integer age;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(insertable = false)
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
