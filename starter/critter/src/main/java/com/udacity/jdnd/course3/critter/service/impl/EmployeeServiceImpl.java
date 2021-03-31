package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long employeeId) throws Exception {
        return employeeRepository.findById(employeeId).orElseThrow(()->
                new Exception("Employee with id "+employeeId+" not found"));
    }

    @Override
    public void setAvailability(Long employeeId) {

    }
}