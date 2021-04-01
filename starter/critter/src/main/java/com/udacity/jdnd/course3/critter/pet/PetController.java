package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = convertDTOToPet(petDTO);
        return convertPetToDTO(petService.save(pet));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) throws Exception{
        Pet pet = petService.findById(petId);
        return convertPetToDTO(pet);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List <Pet> pets= petService.list();
//        return new LinkedList<>(convertPetListToDTO(pets));
        return convertPetListToDTO(petService.list());

    }

/**
 *  try using PetDTO and not Pet check other methods that are using List<>
 *  alternatively use @JsonView approach
 *  add check for non existent owner
 */

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return convertPetListToDTO(petService.findByOwnerId(ownerId));

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
        return petDTO;
    }

    private Pet convertDTOToPet(PetDTO petDTO){
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        petDTO.setOwnerId(pet.getOwner().getId());
        return pet;
    }

    private List<PetDTO> convertPetListToDTO(List<Pet> pets){
        List<PetDTO> DTOList= new ArrayList<>();
        BeanUtils.copyProperties(pets, DTOList);

        Map<List<Pet>, List<PetDTO> > petAndDTOListMap = new HashMap<>();

        return DTOList;

    }
}
