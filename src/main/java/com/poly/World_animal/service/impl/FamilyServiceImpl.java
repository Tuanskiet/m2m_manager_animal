package com.poly.World_animal.service.impl;

import com.poly.World_animal.entity.FamilyAnimal;
import com.poly.World_animal.entity.OrderAnimal;
import com.poly.World_animal.repository.FamilyAnimalRepo;
import com.poly.World_animal.repository.OrderAnimalRepo;
import com.poly.World_animal.service.FamilyAnimalService;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyAnimalService {

    @Autowired
    FamilyAnimalRepo familyAnimalRepo ;
    @Override
    public List<FamilyAnimal> findAll() {
        return familyAnimalRepo.findAll();
    }
}
