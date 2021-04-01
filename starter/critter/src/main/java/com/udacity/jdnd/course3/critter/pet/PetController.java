package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
private final PetService petService;
private final CustomerService customerService;

    public PetController(PetService petService, CustomerService customerService) {
        this.petService = petService;
        this.customerService = customerService;
    }

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Customer owner = customerService.findById(petDTO.getOwnerId());

        Pet petToSave = convertDTOToPet(petDTO);
        petToSave.setOwner(owner);

        return convertPetToDTO(petService.save(petToSave));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) throws Exception{
        Pet pet = petService.findById(petId);
        return convertPetToDTO(pet);
    }


    @GetMapping
    public List<PetDTO> getPets(){
        return petService.list()
                .stream()
                .map(this::convertPetToDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {

        return petService.findByOwnerId(ownerId)
                .stream()
                .map(this::convertPetToDTO)
                .collect(Collectors.toList());
    }


    @PutMapping("/{petId}/addOwner/{ownerId}")
    public  PetDTO addOwner(@PathVariable Long petId, @PathVariable Long ownerId) throws Exception{
        PetDTO petDTO = convertPetToDTO(petService.findById(petId));
        petDTO.setOwnerId(ownerId);
        return convertPetToDTO(petService.addOwner(petId, ownerId));
    }


    private PetDTO convertPetToDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);

        petDTO.setOwnerId(pet.getOwner().getId());

        return petDTO;
    }

    private Pet convertDTOToPet(PetDTO petDTO){
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);

        return pet;
    }


}
