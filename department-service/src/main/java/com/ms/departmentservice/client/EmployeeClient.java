package com.ms.departmentservice.client;

import com.ms.departmentservice.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/employee")
public interface EmployeeClient {

    @GetExchange("/department/{departmentId}")
    ResponseEntity<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
