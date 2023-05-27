package com.ms.employeeservice.repository;

import com.ms.employeeservice.exception.EmployeeNotFoundException;
import com.ms.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1L, 1L, "Pratheeban", 28, "Engineer"),
            new Employee(2L, 2L, "Abiya", 27, "developer"),
            new Employee(3L, 3L, "MichaelRaj", 55, "builder")));

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for given ID: "+ id, "EMPLOYEE_NOT_FOUND"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }
}
