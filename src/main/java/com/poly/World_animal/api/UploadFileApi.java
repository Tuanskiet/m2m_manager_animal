package com.poly.World_animal.api;


import com.poly.World_animal.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UploadFileApi {

    private final FirebaseService firebaseService;

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadOnFirebase(
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()){
            String folder = "animalstt/ab/" ;
            firebaseService.uploadFile(multipartFile, folder);
        }else{
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }
}
