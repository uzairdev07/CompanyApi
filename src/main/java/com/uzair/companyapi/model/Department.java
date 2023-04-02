package com.uzair.companyapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("department")
public class Department {
    @Id
    private String id;
    private String name;

    @JsonCreator
    public Department(@JsonProperty("name") String name) {
        this.name = name;
    }
}
