package com.poly.World_animal.controller;


import com.poly.World_animal.contansts.Message;
import com.poly.World_animal.contansts.MessageError;
import com.poly.World_animal.dto.UserLoginDto;
import com.poly.World_animal.entity.UserApp;
import com.poly.World_animal.service.FirebaseService;
import com.poly.World_animal.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public String doLogin(
            @ModelAttribute(name = "userLogin")UserLoginDto userLoginDto,
                          HttpSession session,
                          Model model){
        String result = userAppService.doLogin(userLoginDto.getUsername(), userLoginDto.getPassword());
        if(result.equals("OK")){
            session.setAttribute("myAccount", userAppService.findByUsername(userLoginDto.getUsername()));
            return "redirect:/";
        }
        model.addAttribute("userLogin", userLoginDto);
        model.addAttribute("error", result);
        return "login";
    }

    @GetMapping("/register")
    public String viewPageRegister(Model model){
//        model.addAttribute("error", "");
        model.addAttribute("userRegister", new UserApp());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute(name = "userRegister")UserApp userApp,
                             @RequestParam("repeatpass_login")String repeat_pass,
                             @RequestParam("image") MultipartFile multipartFile,
                             Model model) throws IOException {
        String result = userAppService.register(userApp);
//        String repeat_pass = (String) model.getAttribute("repeatpass_login");
        if(repeat_pass.equals(userApp.getPassword())){
            if(result.equals(MessageError.USER_REGISTER_SUCCESS)){
//                model.addAttribute("message",MessageError.USER_REGISTER_SUCCESS);
                model.addAttribute("message", Message.User.USER_REGISTER_SUCCESS.getCode());
                model.addAttribute("userRegister", new UserApp());




                //upload img
                if(!multipartFile.isEmpty()){
                    userAppService.uploadAvatarByEmail(userApp.getEmail(), multipartFile);
                }
                return "register";
            }else{
                model.addAttribute("error", result);
                return "register";
            }
        }
        model.addAttribute("error","Mật khẩu không khớp");
        return "register";
    }


    @GetMapping("/info")
    public String viewInfoUser(HttpSession session, Model model){
        UserApp userApp = (UserApp) session.getAttribute("myAccount");
        if(userApp != null){
            model.addAttribute("userRegister", userApp);
        }
        return "register";
    }
}
