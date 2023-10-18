package com.poly.World_animal.controller;

import com.poly.World_animal.entity.SpeciesAnimal;
import com.poly.World_animal.service.SpeciesAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EditController {
    @Autowired
    SpeciesAnimalService speciesAnimalService;
    @GetMapping("/edit_species")
    public String doGetViewEdit(Model model,@RequestParam(defaultValue = "0", value = "page",required = false)int page){
        Properties(model, page);
        model.addAttribute("currentSpeciesAnimals",new SpeciesAnimal());
        return "/admin/edit_species";
    }



    @GetMapping("/edit_species/entity/{species_id}")
    public String doGetOneEditView(Model model, @PathVariable Integer species_id, @RequestParam(defaultValue = "0", value = "page",required = false)int page){

        Optional<SpeciesAnimal> speciesAnimal = speciesAnimalService.findById(species_id);
        Properties(model,page);
        model.addAttribute("currentSpeciesAnimals", speciesAnimal);

        return "/admin/edit_species";
    }

    @PostMapping("/edit_species")
    public String doPostEditView(Model model, @ModelAttribute SpeciesAnimal currentSpeciesAnimals, @RequestParam(defaultValue = "0", value = "page",required = false)int page){
        if(currentSpeciesAnimals.getId() !=null){
            model.addAttribute("message","update thành công");
        }else{
            model.addAttribute("message","Thêm mới thành công");
        }
        speciesAnimalService.save(currentSpeciesAnimals);
        model.addAttribute("currentSpeciesAnimals", new SpeciesAnimal());

        Properties(model,page);

        return "/admin/edit_species";
    }

    private void Properties(Model model, int page) {
        Pageable pageable = PageRequest.of(page,8 );
        Page<SpeciesAnimal> speciesAnimals = speciesAnimalService.findAll(pageable);
        List<SpeciesAnimal> speciesAnimalList = speciesAnimals.getContent();
        int totalPage = speciesAnimals.getSize();

        model.addAttribute("listSpeciesAnimals", speciesAnimalList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",totalPage);
    }
}
