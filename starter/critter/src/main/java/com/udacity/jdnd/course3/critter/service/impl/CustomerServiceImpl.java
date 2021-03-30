package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PetRepository petRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository, PetRepository petRepository) {
        this.customerRepository = customerRepository;
        this.petRepository = petRepository;
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
    public Customer addPet(Long ownerId, Long petId) throws Exception{
        Customer owner = customerRepository.findById(ownerId).orElseThrow(()-> new Exception("Owner with id "+ownerId+" not found"));
        Pet pet = petRepository.findById(petId).orElseThrow(()-> new Exception("Pet with id "+petId+" not found"));

        owner.getPets().add(pet);
       return customerRepository.save(owner);
    }
}
