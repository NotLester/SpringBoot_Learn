package org.lester.springbootlearn.homework1.repositories;

import org.lester.springbootlearn.homework1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}