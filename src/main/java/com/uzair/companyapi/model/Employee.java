package com.uzair.companyapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String departmentId;

    @JsonCreator
    public Employee(@JsonProperty("name") String name, @JsonProperty("departmentId") String departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }
}
