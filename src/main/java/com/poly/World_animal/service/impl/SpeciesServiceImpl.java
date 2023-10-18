package com.poly.World_animal.service.impl;

import com.poly.World_animal.service.SpeciesAnimalService;
import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.repository.OrderAnimalRepo;
import com.poly.World_animal.repository.SpeciesAnimalRepo;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesServiceImpl implements SpeciesAnimalService {

    @Autowired
    SpeciesAnimalRepo speciesAnimalRepo ;

    @Override
    public Page<SpeciesAnimal> findAll(Pageable page) {
        return speciesAnimalRepo.findAll(page);
    }

    @Override
    public Optional<SpeciesAnimal> findById(Integer id) {
        return speciesAnimalRepo.findById(id);
    }

    @Override
    public SpeciesAnimal save(SpeciesAnimal speciesAnimal) {
        return speciesAnimalRepo.save(speciesAnimal);
    }

    @Override
    public void delete(SpeciesAnimal speciesAnimal) {
        speciesAnimalRepo.delete(speciesAnimal);
    }
    public Page<SpeciesAnimal> findByName(String name, Pageable pageable) {
        return speciesAnimalRepo.findByNameContaining(name, pageable);
    }
}
