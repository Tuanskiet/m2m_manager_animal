package com.poly.World_animal.controller;


import com.poly.World_animal.entity.FamilyAnimal;
import com.poly.World_animal.entity.OrderAnimal;
import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.entity.UserApp;
import com.poly.World_animal.service.FamilyAnimalService;
import com.poly.World_animal.service.OrderAnimalService;
import com.poly.World_animal.service.SpeciesAnimalService;
import com.poly.World_animal.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    OrderAnimalService orderAnimalService ;
    @Autowired
    FamilyAnimalService familyAnimalService;
    @Autowired
    SpeciesAnimalService speciesAnimalService;
    @Autowired
    SessionService sessionService;
    @GetMapping({"/", "/index"})
    // hàm
    public String viewHomePage(Model model,@RequestParam(defaultValue = "0", value = "page",required = false)int page){
        List<OrderAnimal> listOrderAnimals = orderAnimalService.findAll();

        model.addAttribute("listOrderAnimals",listOrderAnimals);
        model.addAttribute("sizeOrder",listOrderAnimals.size());

        List<FamilyAnimal> listFamilyAnimals = familyAnimalService.findAll();
        model.addAttribute("listFamilyAnimals", listFamilyAnimals);
        model.addAttribute("sizeFamily",listFamilyAnimals.size());

        Pageable pageable = PageRequest.of(page,8 );
        Page<SpeciesAnimal> speciesAnimals = speciesAnimalService.findAll(pageable);
        List<SpeciesAnimal>speciesAnimalList = speciesAnimals.getContent();
        int totalPage = speciesAnimals.getSize();

        for(SpeciesAnimal spect : speciesAnimalList){
            System.out.println("1: "+spect.getId());
        }
        model.addAttribute("listSpeciesAnimals", speciesAnimalList);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",totalPage);

        UserApp userLogin = sessionService.get("userLogin");
        model.addAttribute("userLogin",userLogin);
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
//    @GetMapping("/species-detail/{id_species}")
//    public String viewSpeciesDetails(Model model, @PathVariable("id_species") Integer id){
//        Optional<SpeciesAnimal> findSpeciesByid = speciesAnimalService.findById(id);
//
//        if(findSpeciesByid.isPresent()){
//            model.addAttribute("species_details",findSpeciesByid.get());
//        }
//        return "/user/details";
//    }
@GetMapping("/species-detail")
public String viewSpeciesDetails(Model model, @RequestParam("species_id") Integer id){
    Optional<SpeciesAnimal> findSpeciesByid = speciesAnimalService.findById(id);

    if(findSpeciesByid.isPresent()){
        model.addAttribute("species_details",findSpeciesByid.get());
    }
    return "/user/details";
}

}
