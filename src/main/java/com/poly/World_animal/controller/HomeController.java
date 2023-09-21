package com.poly.World_animal.controller;


import com.poly.World_animal.entity.FamilyAnimal;
import com.poly.World_animal.entity.OrderAnimal;
import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.service.FamilyAnimalService;
import com.poly.World_animal.service.OrderAnimalService;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    OrderAnimalService orderAnimalService ;
    @Autowired
    FamilyAnimalService familyAnimalService;
    @Autowired
    SpeciesAnimalService speciesAnimalService;
    @GetMapping({"/", "/index"})
    // hàm
    public String viewHomePage(Model model,
                               @RequestParam(defaultValue = "0", value = "page",required = false)int page,
                               @RequestParam(defaultValue = "", value = "keyword",required = false)String keyword){
        List<OrderAnimal> listOrderAnimals = orderAnimalService.findAll();

        model.addAttribute("listOrderAnimals",listOrderAnimals);
        model.addAttribute("sizeOrder",listOrderAnimals.size());

        List<FamilyAnimal> listFamilyAnimals = familyAnimalService.findAll();
        model.addAttribute("listFamilyAnimals", listFamilyAnimals);
        model.addAttribute("sizeFamily",listFamilyAnimals.size());

        Pageable pageable = PageRequest.of(page,8 );
        Page<SpeciesAnimal> speciesAnimals = null;

        if(!keyword.equals("")){
            speciesAnimals = speciesAnimalService.findByName(keyword, pageable);
        }else{
            speciesAnimals = speciesAnimalService.findAll(pageable);
        }

        List<SpeciesAnimal>speciesAnimalList = speciesAnimals.getContent();
        int totalPage = speciesAnimals.getSize();

        model.addAttribute("listSpeciesAnimals", speciesAnimalList);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",totalPage);
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
