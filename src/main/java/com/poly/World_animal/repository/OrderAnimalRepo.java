package com.poly.World_animal.repository;

import com.poly.World_animal.entity.OrderAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAnimalRepo extends JpaRepository<OrderAnimal,Integer> {
    List<OrderAnimal> findAll();

}
