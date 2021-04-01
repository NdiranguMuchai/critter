package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Pet;

import java.util.List;

public interface PetService {
    Pet save(Pet pet);
    List<Pet> list();
    Pet findById(Long id) throws Exception;
    List<Pet> findByOwnerId(Long ownerId);
}
