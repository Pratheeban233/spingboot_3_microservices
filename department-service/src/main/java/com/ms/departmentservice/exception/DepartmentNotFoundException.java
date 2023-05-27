package com.ms.departmentservice.exception;

import lombok.Data;

@Data
public class DepartmentNotFoundException extends RuntimeException {

    private String errorCode;

    public DepartmentNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
