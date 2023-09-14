package com.poly.World_animal.service;


import com.poly.World_animal.entity.SpeciesAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpeciesAnimalService {
   Page<SpeciesAnimal> findAll(Pageable page);
}
