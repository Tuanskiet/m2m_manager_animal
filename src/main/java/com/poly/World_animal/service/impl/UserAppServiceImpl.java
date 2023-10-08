package com.poly.World_animal.service.impl;

import com.poly.World_animal.contansts.MessageError;
import com.poly.World_animal.entity.UserApp;
import com.poly.World_animal.repository.UserAppRepo;
import com.poly.World_animal.service.FirebaseService;
import com.poly.World_animal.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserAppServiceImpl implements UserAppService {

    private final UserAppRepo userAppRepo;
    private final FirebaseService firebaseService;


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
        userAppRepo.save(userApp);
        return MessageError.USER_REGISTER_SUCCESS;
    }

    @Override
    public void uploadAvatarByEmail(String email, MultipartFile multipartFile) {
        Optional<UserApp> userApp = userAppRepo.findByEmail(email);
        if(userApp.isPresent()){
            String folder = "user/" + userApp.get().getId() + "/" ;
            try {
                String url = firebaseService.uploadFile( multipartFile, folder);
                userApp.get().setAvatar(url);
                userAppRepo.save(userApp.get());
            } catch (IOException e) {
                throw new RuntimeException("Error while upload file!");
            }
        }
    }

    @Override
    public UserApp findByUsername(String username) {
        return userAppRepo.findByEmail(username).orElse(null);
    }
}
