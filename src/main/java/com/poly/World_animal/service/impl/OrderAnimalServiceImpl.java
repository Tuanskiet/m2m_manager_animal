package com.poly.World_animal.service.impl;

import com.poly.World_animal.entity.OrderAnimal;
import com.poly.World_animal.repository.OrderAnimalRepo;
import com.poly.World_animal.service.OrderAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //khai bao để nhận biết tầng sử lý bussines
public class OrderAnimalServiceImpl implements OrderAnimalService {

     @Autowired
    OrderAnimalRepo orderAnimalRepo ;
    @Override
    public List<OrderAnimal> findAll() {
        return orderAnimalRepo.findAll();
    }
}

