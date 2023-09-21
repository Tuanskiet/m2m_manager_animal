package com.poly.World_animal.repository;

import com.poly.World_animal.entity.SpeciesAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesAnimalRepo extends JpaRepository<SpeciesAnimal, Integer> {
    List<SpeciesAnimal> findAll();

    Page<SpeciesAnimal> findByNameContaining(String name, Pageable pageable);
}
