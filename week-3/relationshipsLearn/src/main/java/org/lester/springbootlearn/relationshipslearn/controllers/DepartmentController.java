package org.lester.springbootlearn.relationshipslearn.controllers;

import org.lester.springbootlearn.relationshipslearn.entities.DepartmentEntity;
import org.lester.springbootlearn.relationshipslearn.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping(path = "/{departmentId}/assign-manager/{managerId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long managerId) {
        return departmentService.assignManagerToDepartment(departmentId, managerId);
    }
}
