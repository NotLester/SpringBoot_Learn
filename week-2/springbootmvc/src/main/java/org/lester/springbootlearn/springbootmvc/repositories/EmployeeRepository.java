package org.lester.springbootlearn.springbootmvc.repositories;

import org.lester.springbootlearn.springbootmvc.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> { }

