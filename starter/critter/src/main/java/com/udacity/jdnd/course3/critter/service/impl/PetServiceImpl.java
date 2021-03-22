package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
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
}
