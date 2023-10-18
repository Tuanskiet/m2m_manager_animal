package com.poly.World_animal.service;

import com.poly.World_animal.entity.UserApp;
import org.springframework.web.multipart.MultipartFile;

public interface UserAppService {
    String doLogin(String email, String password);
    String register(UserApp userApp);

    UserApp findByEmailAndPassword(String email, String password);

    void uploadAvatarByEmail(String email, MultipartFile multipartFile);

    UserApp findByUsername(String username);
}
