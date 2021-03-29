package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer>list();
    Customer findOwnerByPetId(Long petId) throws Exception;
    void addPet(Customer customer, Pet pet);
}
