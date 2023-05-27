package com.ms.employeeservice.exception;

import lombok.Data;

@Data
public class EmployeeNotFoundException extends RuntimeException {

    private String errorCode;

    public EmployeeNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
