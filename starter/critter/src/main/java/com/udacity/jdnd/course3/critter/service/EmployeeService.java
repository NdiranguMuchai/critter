package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee findById(Long employeeId)throws Exception;
    void setAvailability(Set<DayOfWeek> availability, Long employeeId) throws Exception;
    Set<Employee> findEmployeesForService(LocalDate localDate, HashSet<EmployeeSkill> skills);
    List<Employee> list();

}
