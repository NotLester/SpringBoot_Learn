package org.lester.springbootlearn.learnfinalfinal.repositories;

import org.lester.springbootlearn.learnfinalfinal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}