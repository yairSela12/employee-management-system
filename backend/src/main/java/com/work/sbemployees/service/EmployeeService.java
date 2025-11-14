package com.work.sbemployees.service;

import com.work.sbemployees.model.Employee;
import com.work.sbemployees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {


    List<Employee> getListOfEmployees();
    Employee getEmployeeById(Integer id);

    Employee updateEmployee(Employee employee , Integer id);

    Employee addEmployee(Employee employee);
    void deleteEmployee(Integer id);


}