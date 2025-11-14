package com.work.sbemployees.exception;

public class EmployeeNotExist extends RuntimeException {
    public EmployeeNotExist(String massage) {
        super(massage);
    }
}
