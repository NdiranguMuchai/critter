package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule create(Schedule schedule);
    List<Schedule> list();
    List<Schedule> findScheduleByPet(Long petId);
    List<Schedule> findScheduleByEmployee(Long employeeId);
    List<Schedule> findScheduleByCustomer(Long customerId);
}
