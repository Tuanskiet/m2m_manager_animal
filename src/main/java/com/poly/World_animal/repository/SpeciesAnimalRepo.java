package com.poly.World_animal.repository;

import com.poly.World_animal.entity.SpeciesAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesAnimalRepo extends JpaRepository<SpeciesAnimal, Integer> {
}
