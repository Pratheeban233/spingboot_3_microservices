package com.ms.departmentservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Department {

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;
    private List<Employee> employees;

}
