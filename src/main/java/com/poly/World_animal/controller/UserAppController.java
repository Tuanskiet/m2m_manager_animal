package com.poly.World_animal.controller;


import com.poly.World_animal.dto.UserLoginDto;
import com.poly.World_animal.entity.UserApp;
import com.poly.World_animal.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserAppController {

    private final UserAppService userAppService;
    @GetMapping("/login")
    public String viewPageLogin(Model model){
//        model.addAttribute("error", "");
        model.addAttribute("userLogin", new UserLoginDto());
        return "login";
    }
    @PostMapping("/login")
    public String doLogin(@ModelAttribute(name = "userLogin")UserLoginDto userLoginDto,
                          Model model){
        String result = userAppService.doLogin(userLoginDto.getUsername(), userLoginDto.getPassword());
        if(result.equals("OK")){
            return "/user/index";
        }
        model.addAttribute("userLogin", userLoginDto);
        model.addAttribute("error", result);
        return "login";
    }
}
