package com.ms.departmentservice.controller;

import com.ms.departmentservice.client.EmployeeClient;
import com.ms.departmentservice.model.Department;
import com.ms.departmentservice.model.Employee;
import com.ms.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return new ResponseEntity<>(departmentRepository.addDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        List<Department> allDepartments = departmentRepository.findAll();
        LOGGER.info("All Departments : {}", allDepartments);
        return ResponseEntity.ok(allDepartments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable("id") Long id) {
        Department department = departmentRepository.findById(id);
        LOGGER.info("Department by id:{}, {}", id, department);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/with-employees")
    public ResponseEntity<List<Department>> findAllDepartmentWithEmployees() {
        List<Department> allDepartments = departmentRepository.findAll();
        allDepartments.forEach(department -> department
                .setEmployees(employeeClient.findByDepartment(department.getId()).getBody()));
        LOGGER.info("All Departments : {}", allDepartments);
        return ResponseEntity.ok(allDepartments);
    }
}
