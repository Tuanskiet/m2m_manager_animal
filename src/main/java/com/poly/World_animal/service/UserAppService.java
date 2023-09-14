package com.poly.World_animal.service;

import com.poly.World_animal.entity.UserApp;

public interface UserAppService {
    String doLogin(String email, String password);

    String register(UserApp userApp);
}
