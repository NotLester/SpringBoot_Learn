package org.lester.springbootlearn.relationshipslearn.repositories;

import org.lester.springbootlearn.relationshipslearn.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
