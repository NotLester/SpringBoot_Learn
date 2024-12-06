package org.lester.springbootlearn.relationshipslearn.repositories;

import org.lester.springbootlearn.relationshipslearn.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
