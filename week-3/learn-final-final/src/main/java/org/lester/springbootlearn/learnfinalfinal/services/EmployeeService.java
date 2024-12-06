package org.lester.springbootlearn.learnfinalfinal.services;

import org.lester.springbootlearn.learnfinalfinal.entities.Employee;
import org.lester.springbootlearn.learnfinalfinal.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
