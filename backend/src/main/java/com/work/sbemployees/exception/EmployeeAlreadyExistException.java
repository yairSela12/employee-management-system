package com.work.sbemployees.exception;

public class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException(String massage) {
        super(massage);
    }
}
