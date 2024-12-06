package org.lester.springbootlearn.learnfinalfinal.repositories;

import org.lester.springbootlearn.learnfinalfinal.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByManager_Id(Long managerId);
}