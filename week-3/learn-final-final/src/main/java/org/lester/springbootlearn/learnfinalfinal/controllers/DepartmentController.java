package org.lester.springbootlearn.learnfinalfinal.controllers;

import org.lester.springbootlearn.learnfinalfinal.entities.Department;
import org.lester.springbootlearn.learnfinalfinal.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(path = "/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping(path = "/{managerId}/department")
    public Department getDepartmentByManagerId(@PathVariable Long managerId) {
        return departmentService.findDepartmentByManagerId(managerId);
    }


    @PostMapping(path = "")
    public Department createNewDepartment(@RequestBody Department department) {
        System.out.println("Department title: " + department.getTitle());  // Debug log
        return departmentService.createNewDepartment(department);
    }

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public Department assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.assignManagerToDepartment(departmentId, employeeId);
    }

    @PutMapping(path = "/{departmentId}/worker/{employeeId}")
    public Department assignWorkerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.assignWorkerToDepartment(departmentId, employeeId);
    }
}


