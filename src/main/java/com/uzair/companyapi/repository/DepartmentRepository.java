package com.uzair.companyapi.repository;

import com.uzair.companyapi.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
