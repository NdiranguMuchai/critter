package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOwnerByPetId(Long petId) throws Exception{
        Customer customer = new Customer();

        if (customer.getPets().isEmpty()){
            throw new Exception("The owner has no pets");
        }
        if (petId == null){
            throw new Exception("Pet with id "+petId+" does not exist");
        }
        else {
            return customerRepository.findCustomerByPets(petId);
        }
    }
    @Override
    public void addPet(Customer customer, Pet pet){
        List<Pet> pets = customer.getPets();
        if (pets == null) {
            pets = new ArrayList<Pet>();
        }
        pets.add(pet);
        customer.setPets(pets);
        customerRepository.save(customer);
    }
}
