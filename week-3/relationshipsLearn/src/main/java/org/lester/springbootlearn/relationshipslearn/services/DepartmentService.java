package org.lester.springbootlearn.relationshipslearn.services;

import org.lester.springbootlearn.relationshipslearn.entities.DepartmentEntity;
import org.lester.springbootlearn.relationshipslearn.entities.EmployeeEntity;
import org.lester.springbootlearn.relationshipslearn.repositories.DepartmentRepository;
import org.lester.springbootlearn.relationshipslearn.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long managerId) {
        DepartmentEntity dept = departmentRepository.findById(departmentId).orElse(null);
        EmployeeEntity employee = employeeRepository.findById(managerId).orElse(null);
        if (dept == null || employee == null) return null;
//        dept.setManager(employee);
        return departmentRepository.save(dept);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long workerId) {
        DepartmentEntity dept = departmentRepository.findById(departmentId).orElse(null);
        EmployeeEntity employee = employeeRepository.findById(workerId).orElse(null);
        if (dept == null || employee == null) return null;
        dept.getWorkers().add(employee);
        employee.setWorkerDepartment(dept);
        employeeRepository.save(employee);
        return departmentRepository.save(dept);
    }
}
