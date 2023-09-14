package com.poly.World_animal.repository;

import com.poly.World_animal.entity.FamilyAnimal;
import com.poly.World_animal.entity.OrderAnimal;
import com.poly.World_animal.entity.SpeciesAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyAnimalRepo extends JpaRepository<FamilyAnimal, Integer> {
    List<FamilyAnimal> findAll();
}
