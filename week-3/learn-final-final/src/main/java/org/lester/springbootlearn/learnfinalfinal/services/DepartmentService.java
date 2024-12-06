package org.lester.springbootlearn.learnfinalfinal.services;

import org.lester.springbootlearn.learnfinalfinal.entities.Department;
import org.lester.springbootlearn.learnfinalfinal.entities.Employee;
import org.lester.springbootlearn.learnfinalfinal.repositories.DepartmentRepository;
import org.lester.springbootlearn.learnfinalfinal.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Department createNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        return department.flatMap(dept -> employee.map(emp -> {
            dept.setManager(emp);
            emp.setManagedDepartment(dept);
            employeeRepository.save(emp);
            return departmentRepository.save(dept);
        })).orElse(null);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentByManagerId(Long managerId) {
        return departmentRepository.findDepartmentByManager_Id(managerId);
    }

    public Department assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        return department.flatMap(dept -> employee.map(emp -> {
            emp.setDepartment(dept);
            employeeRepository.save(emp);
            dept.getEmployees().add(emp);
            return departmentRepository.save(dept);
        })).orElse(null);
    }
}
