package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> list() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findScheduleByPet(Long petId) {
        return null;
    }

    @Override
    public List<Schedule> findScheduleByEmployee(Long employeeId) {
        return null;
    }

    @Override
    public List<Schedule> findScheduleByCustomer(Long customerId) {
        return null;
    }
}
