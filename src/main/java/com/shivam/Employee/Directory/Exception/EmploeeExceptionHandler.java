package com.shivam.Employee.Directory.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmploeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeCustomError> handleException(EmployeeNotFoundException exc){
        EmployeeCustomError employeeCustomError=new EmployeeCustomError(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(employeeCustomError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeCustomError> handleException(Exception exc){
        EmployeeCustomError employeeCustomError=new EmployeeCustomError(HttpStatus.BAD_REQUEST.value(),"Bad Request",System.currentTimeMillis());
        return new ResponseEntity<>(employeeCustomError,HttpStatus.BAD_REQUEST);
    }
}
