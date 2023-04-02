package com.uzair.companyapi.controller;

import com.uzair.companyapi.model.Employee;
import com.uzair.companyapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeRepository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(201).body(
                employeeRepository.save(employee)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable String id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (employeeById.isPresent()) {
            employeeRepository.delete(employeeById.get());
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("The employee with " + id + " not found.");
    }

}
