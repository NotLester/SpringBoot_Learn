package org.lester.springbootlearn.springbootmvc.services;

import org.lester.springbootlearn.springbootmvc.dto.EmployeeDTO;
import org.lester.springbootlearn.springbootmvc.entities.EmployeeEntity;
import org.lester.springbootlearn.springbootmvc.exceptions.ResourceNotFoundException;
import org.lester.springbootlearn.springbootmvc.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();
    }

    public Optional<EmployeeDTO> getEmployeeById(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) return Optional.empty();
        return Optional.of(modelMapper.map(employee, EmployeeDTO.class));
    }

    public EmployeeDTO createEmployee(EmployeeDTO newEmployee) {
        EmployeeEntity employee = modelMapper.map(newEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO newEmployeeInfo) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
        }
        EmployeeEntity updatedEmployee = modelMapper.map(newEmployeeInfo, EmployeeEntity.class);
        employeeRepository.save(updatedEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO deleteEmployee(Long employeeId) {
        Optional<EmployeeEntity> employeeToDelete = employeeRepository.findById(employeeId);
        if (employeeToDelete.isEmpty()) throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
        employeeRepository.delete(employeeToDelete.get());
        return modelMapper.map(employeeToDelete, EmployeeDTO.class);
    }

    public EmployeeDTO patchEmployee(Long employeeId, Map<String, Object> updates) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) return null;
        updates.forEach((key, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, key);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employee, value);
        });
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
