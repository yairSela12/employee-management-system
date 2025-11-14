package com.work.sbemployees.service;

import com.work.sbemployees.exception.EmployeeAlreadyExistException;
import com.work.sbemployees.exception.EmployeeNotExist;
import com.work.sbemployees.model.Employee;
import com.work.sbemployees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{


    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getListOfEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotExist("Unfortunately, an employee with such an ID number is no longer in the database, it may have been deleted by another user, therefore the update operation is not possible."));
    }


    @Override
    public Employee updateEmployee(Employee newEmployeeDetails, Integer id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null){
            if(employeeRepository.existsByEmail(newEmployeeDetails.getEmail()) &&
                    !newEmployeeDetails.getEmail().equals(employee.getEmail())){
                throw new EmployeeAlreadyExistException("the Email you provided is already belong to other Employee");
            }
            employee.setFirstName(newEmployeeDetails.getFirstName());
            employee.setLastName(newEmployeeDetails.getLastName());
            employee.setEmail((newEmployeeDetails.getEmail()));
            employeeRepository.save(employee);

        }
        else{
            throw new EmployeeNotExist("Unfortunately, an employee with such an ID number is no longer in the database, it may have been deleted by another user, therefore the update operation is not possible.");
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new EmployeeAlreadyExistException("the Email you provided is already belong to other Employee");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
}


