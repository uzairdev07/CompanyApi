package com.uzair.companyapi.repository;

import com.uzair.companyapi.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    ResponseEntity<Employee> findAllByDepartmentId(String id);
}
