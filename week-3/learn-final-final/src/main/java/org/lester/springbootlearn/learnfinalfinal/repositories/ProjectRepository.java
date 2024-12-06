package org.lester.springbootlearn.learnfinalfinal.repositories;

import org.lester.springbootlearn.learnfinalfinal.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}