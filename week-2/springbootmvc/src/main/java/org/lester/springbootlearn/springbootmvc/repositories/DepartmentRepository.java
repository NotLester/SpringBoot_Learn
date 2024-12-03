package org.lester.springbootlearn.springbootmvc.repositories;

import org.lester.springbootlearn.springbootmvc.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> { }
