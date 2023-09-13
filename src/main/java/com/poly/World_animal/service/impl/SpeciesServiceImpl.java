package com.poly.World_animal.service.impl;

import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.repository.OrderAnimalRepo;
import com.poly.World_animal.repository.SpeciesAnimalRepo;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesAnimalService {

    @Autowired
    SpeciesAnimalRepo speciesAnimalRepo ;
    @Override
    public List<SpeciesAnimal> findAll() {
        return speciesAnimalRepo.findAll();
    }
}
