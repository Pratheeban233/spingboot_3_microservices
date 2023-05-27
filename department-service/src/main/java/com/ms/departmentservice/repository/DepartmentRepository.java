package com.ms.departmentservice.repository;

import com.ms.departmentservice.exception.DepartmentNotFoundException;
import com.ms.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departmentList = new ArrayList<>(List.of(
            new Department(1L, "MECH"),
            new Department(2L, "IT"),
            new Department(3L, "CIVIL")
    ));

    public Department addDepartment(Department department) {
        departmentList.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departmentList.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found for given ID: " + id, "DEPARTMENT_NOT_FOUND"));
    }

    public List<Department> findAll() {
        return departmentList;
    }
}
