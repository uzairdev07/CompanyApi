package com.uzair.companyapi.controller;


import com.uzair.companyapi.model.Department;
import com.uzair.companyapi.model.Employee;
import com.uzair.companyapi.repository.DepartmentRepository;
import com.uzair.companyapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity createDepartment(@RequestBody Department department) {
        return ResponseEntity.status(201).body(
                departmentRepository.save(department)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepartmentById(@PathVariable String id) {
        return ResponseEntity.ok(departmentRepository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartmentById(@PathVariable String id) {
        Optional<Department> departmentById = departmentRepository.findById(id);
        if (departmentById.isPresent()) {
            departmentRepository.delete(departmentById.get());
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("The department with " + id + " not found.");
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<Employee> getEmployeesByDepartmentId(@PathVariable String id) {
        return employeeRepository.findAllByDepartmentId(id);
    }

}
