    package org.lester.springbootlearn.springbootmvc.controllers;

    import jakarta.validation.Valid;
    import org.lester.springbootlearn.springbootmvc.dto.EmployeeDTO;
    import org.lester.springbootlearn.springbootmvc.exceptions.ResourceNotFoundException;
    import org.lester.springbootlearn.springbootmvc.services.EmployeeService;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Map;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/v1/employees")
    public class EmployeeController {
        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping(path = "/{employeeId}")
        public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeId) {
            Optional<EmployeeDTO> employee = employeeService.getEmployeeById(employeeId);
            return employee
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        }


        @GetMapping(path = "")
        public ResponseEntity<List<EmployeeDTO>> getEmployeeByAge(@RequestParam(name = "inputAge", required = false) Integer age, @RequestParam(required = false) String sortBy) {
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        }

        @PostMapping(path = "")
        public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO newEmployee) {
            return new ResponseEntity<>(employeeService.createEmployee(newEmployee), HttpStatus.CREATED);
        }

        @PutMapping(path = "/{employeeId}")
        public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId, @RequestBody @Valid EmployeeDTO newEmployeeInfo) {
            return new ResponseEntity<>(employeeService.updateEmployee(employeeId, newEmployeeInfo), HttpStatus.OK);
        }

        @DeleteMapping(path = "/{employeeId}")
        public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long employeeId) {
            return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
        }

        @PatchMapping(path = "/{employeeId}")
        public ResponseEntity<EmployeeDTO> patchEmployee(@PathVariable Long employeeId, @RequestBody Map<String, Object> updates) {
            return new ResponseEntity<>(employeeService.patchEmployee(employeeId, updates), HttpStatus.OK);

        }
    }
