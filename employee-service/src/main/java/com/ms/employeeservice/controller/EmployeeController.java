package com.ms.employeeservice.controller;

import com.ms.employeeservice.model.Employee;
import com.ms.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        LOGGER.info("Employee add :{}", employee);
        return new ResponseEntity<>(employeeRepository.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        LOGGER.info("All Employees : {}", employeeList);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id){
        Employee employee = employeeRepository.findById(id);
        LOGGER.info("Employee by id:{}, {}", id, employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentId);
        LOGGER.info("Employees from department={}, {}", departmentId, employeeList);
        return ResponseEntity.ok(employeeList);
    }
}
