package com.poly.World_animal.service.impl;

import com.poly.World_animal.contansts.MessageError;
import com.poly.World_animal.entity.UserApp;
import com.poly.World_animal.repository.UserAppRepo;
import com.poly.World_animal.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserAppServiceImpl implements UserAppService {

    private final UserAppRepo userAppRepo;
    @Override
    public String doLogin(String email, String password) {
        Optional<UserApp> userApp = userAppRepo.findByEmail(email);
        if(userApp.isPresent()){
            if(userApp.get().getPassword().equals(password)) return "OK";
            return MessageError.PASS_NOT_MATCH;
        }
        return MessageError.USER_NOT_EXIST;
    }

    @Override
    public String register(UserApp userApp) {
        Optional<UserApp> userAppcheck = userAppRepo.findByEmail(userApp.getEmail());
        if(userAppcheck.isPresent()){
            return MessageError.EMAIL_ALREADY_EXITS;
        }
        return MessageError.USER_REGISTER_SUCCESS;
    }
}
