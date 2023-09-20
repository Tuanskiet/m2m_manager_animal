package com.poly.World_animal.repository;


import com.poly.World_animal.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepo extends JpaRepository<UserApp, Integer> {
    Optional<UserApp> findByEmail(String email);
    Optional<UserApp> findByEmailAndPassword(String email,String password);

}
