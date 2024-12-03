package org.lester.springbootlearn.springbootmvc.controllers;

import jakarta.validation.Valid;
import org.lester.springbootlearn.springbootmvc.dto.DepartmentDTO;
import org.lester.springbootlearn.springbootmvc.services.DepartmentService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long departmentId) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> createDepartment(@RequestBody @Valid DepartmentDTO newDepartment) {
        DepartmentDTO department = departmentService.createDepartment(newDepartment);
        return ResponseEntity.ok(department);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long departmentId, @RequestBody @Valid DepartmentDTO newDepartmentInfo) {
        DepartmentDTO department = departmentService.updateDepartment(departmentId, newDepartmentInfo);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId) {
        DepartmentDTO department = departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok(department);
    }
}
