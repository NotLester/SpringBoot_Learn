package org.lester.springbootlearn.homework1.repositories;

import org.lester.springbootlearn.homework1.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}