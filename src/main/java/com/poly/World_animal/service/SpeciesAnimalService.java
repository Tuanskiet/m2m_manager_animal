package com.poly.World_animal.service;
import com.poly.World_animal.entity.SpeciesAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface SpeciesAnimalService {
   Page<SpeciesAnimal> findAll(Pageable page);
   Optional<SpeciesAnimal> findById(Integer id);

   SpeciesAnimal save(SpeciesAnimal speciesAnimal);

   void delete(SpeciesAnimal speciesAnimal);

    Page<SpeciesAnimal> findByName(String name, Pageable pageable);
}
