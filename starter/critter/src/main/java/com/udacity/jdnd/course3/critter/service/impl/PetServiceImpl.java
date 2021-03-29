package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetServiceImpl(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> list() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) throws Exception{
        return petRepository.findById(id).orElseThrow(()-> new Exception("Pet with id "+id+" not found"));
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {

        return null;
    }


    @Override
    public Pet addOwner(Long petId, Long ownerId) throws Exception{
        Pet pet = petRepository.findById(petId).orElseThrow(()-> new Exception("Pet with id  "+petId+" not found"));

        Customer owner = customerRepository.findById(ownerId).orElseThrow(()-> new Exception("Owner with id  "+ownerId+" not found"));

        pet.setOwner(owner);
        return petRepository.save(pet);
    }
}
