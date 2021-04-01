package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;

import java.time.DayOfWeek;
import java.util.Set;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee findById(Long employeeId)throws Exception;
    void setAvailability(Set<DayOfWeek> availability, Long employeeId) throws Exception;

}
