package com.poly.World_animal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/index"})
    public String viewHomePage(){
        return "/user/index";
    }
    @GetMapping("/details")
    public String viewDetailPage(){
        return "/user/details";
    }
    @GetMapping("/contact")
    public String viewContactPage(){
        return "/user/contact";
    }

    @GetMapping("/blog")
    public String viewBlogPage(){
        return "/user/blog";
    }
    @GetMapping("/blog-detail")
    public String viewBlogDetailsPage(){
        return "/user/blog-details";
    }
}
