package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule create(Schedule schedule);
    List<Schedule> list();
    List<Schedule> findScheduleByPet(Pet pet);
    List<Schedule> findScheduleByEmployee(Employee employee);
    List<Schedule> findScheduleByCustomer(Customer customer);
}
