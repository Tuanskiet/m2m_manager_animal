package com.poly.World_animal.controller;

import com.poly.World_animal.utils.SaveFileUntil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class uploadfile {
    private static final Path root_avt = Paths.get("src/upload/test");

    @GetMapping("/uploadfile")
    public String uploadFile( Model model){
        return "/admin/edit_species";
    }
    @PostMapping("/uploadfile")
    public String PostFile(@RequestParam("file") MultipartFile file, Model model){
        try {
            SaveFileUntil.save(file,root_avt);

            return "/admin/edit_species";
        } catch (Exception e) {
            model.addAttribute("message", "Lỗi upload file!");
            return "/admin/edit_species";
        }
    }
}
