package com.poly.World_animal.controller;


import com.poly.World_animal.entity.FamilyAnimal;
import com.poly.World_animal.entity.OrderAnimal;
import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.service.FamilyAnimalService;
import com.poly.World_animal.service.OrderAnimalService;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    OrderAnimalService orderAnimalService;
    @Autowired
    FamilyAnimalService familyAnimalService;
    @Autowired
    SpeciesAnimalService speciesAnimalService;
    @GetMapping({"/", "/index"})
    public String viewHomePage(Model model){
        List<OrderAnimal> listOrderAnimals = orderAnimalService.findAll();
        model.addAttribute("listOrderAnimals",listOrderAnimals);

        List<FamilyAnimal> listFamilyAnimals = familyAnimalService.findAll();
        model.addAttribute("listFamilyAnimals", listFamilyAnimals);

        List<SpeciesAnimal> listSpeciesAnimals = speciesAnimalService.findAll();
        model.addAttribute("listSpeciesAnimals", listSpeciesAnimals);

        return "/user/index";

    }
    @GetMapping("/detail")
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
