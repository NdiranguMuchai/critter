package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
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
    public List<Schedule> findScheduleByPet(Pet pet) {
        return scheduleRepository.findScheduleByPets(pet);
    }

    @Override
    public List<Schedule> findScheduleByEmployee(Employee employee) {
        return scheduleRepository.findScheduleByEmployees(employee);
    }

    @Override
    public List<Schedule> findScheduleByCustomer(Customer customer) {
        List<Pet> pets = customer.getPets();
        List<Schedule> schedules = new LinkedList<>();

        pets.forEach(pet -> {
            List<Schedule> petsOnSchedule = scheduleRepository.findScheduleByPets(pet);
            schedules.addAll(petsOnSchedule);
        });

        return schedules;
    }
}
