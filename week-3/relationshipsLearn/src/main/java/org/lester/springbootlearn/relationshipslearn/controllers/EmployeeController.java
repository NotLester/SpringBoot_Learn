package org.lester.springbootlearn.relationshipslearn.controllers;

import org.lester.springbootlearn.relationshipslearn.entities.EmployeeEntity;
import org.lester.springbootlearn.relationshipslearn.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping(path = "/create")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createNewEmployee(employeeEntity);
    }
}
