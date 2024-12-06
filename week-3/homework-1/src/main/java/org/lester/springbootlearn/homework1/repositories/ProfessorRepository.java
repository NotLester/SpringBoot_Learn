package org.lester.springbootlearn.homework1.repositories;

import org.lester.springbootlearn.homework1.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}