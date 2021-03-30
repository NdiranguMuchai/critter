package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee findById(Long employeeId)throws Exception;
    void setAvailability(Long employeeId);

}
