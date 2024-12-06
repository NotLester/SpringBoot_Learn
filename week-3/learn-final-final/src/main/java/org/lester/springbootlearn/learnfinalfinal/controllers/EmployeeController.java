package org.lester.springbootlearn.learnfinalfinal.controllers;

import org.lester.springbootlearn.learnfinalfinal.entities.Employee;
import org.lester.springbootlearn.learnfinalfinal.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @PostMapping(path = "")
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return employeeService.createNewEmployee(employee);
    }
}
