package com.employee.ecommerceapi_UsingJwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeException extends RuntimeException{

    public EmployeeException(String message) {
        super(message);
    }
}
