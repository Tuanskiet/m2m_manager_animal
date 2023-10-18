package com.poly.World_animal.RestController;

import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    SpeciesAnimalService speciesAnimalService;
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> doPostDelete(@PathVariable Integer id){
        SpeciesAnimal speciesAnimal = speciesAnimalService.findById(id).get();
        speciesAnimalService.delete(speciesAnimal);

        return ResponseEntity.ok(speciesAnimal.getName());
    }
}
