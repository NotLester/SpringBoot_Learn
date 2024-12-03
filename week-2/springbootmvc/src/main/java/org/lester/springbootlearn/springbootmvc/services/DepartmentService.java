package org.lester.springbootlearn.springbootmvc.services;

import org.lester.springbootlearn.springbootmvc.dto.DepartmentDTO;
import org.lester.springbootlearn.springbootmvc.entities.DepartmentEntity;
import org.lester.springbootlearn.springbootmvc.exceptions.ResourceNotFoundException;
import org.lester.springbootlearn.springbootmvc.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departments = departmentRepository.findAll();
        return departments
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .toList();
    }

    public DepartmentDTO getDepartmentById(Long departmentId) {
        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            throw new ResourceNotFoundException("Department not found with id: " + departmentId);
        }
        return modelMapper.map(department.get(), DepartmentDTO.class);
    }

    public DepartmentDTO createDepartment(DepartmentDTO newDepartment) {
        DepartmentEntity department = modelMapper.map(newDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO newDepartmentInfo) {
        if (!departmentRepository.existsById(departmentId)) {
            throw new ResourceNotFoundException("Department not found with id: " + departmentId);
        }
        DepartmentEntity updatedDepartment = modelMapper.map(newDepartmentInfo, DepartmentEntity.class);
        departmentRepository.save(updatedDepartment);
        return modelMapper.map(updatedDepartment, DepartmentDTO.class);
    }

    public DepartmentDTO deleteDepartment(Long departmentId) {
        Optional<DepartmentEntity> departmentToDelete = departmentRepository.findById(departmentId);
        if (departmentToDelete.isEmpty()) {
            throw new ResourceNotFoundException("Department not found with id: " + departmentId);
        }
        departmentRepository.delete(departmentToDelete.get());
        return modelMapper.map(departmentToDelete.get(), DepartmentDTO.class);
    }
}
