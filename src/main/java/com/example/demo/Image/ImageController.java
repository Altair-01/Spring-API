package com.example.demo.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private StorageService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadImage = service.uploadImage((file));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(uploadImage);
    }

   @GetMapping("/{fileName}")
   @ResponseStatus(HttpStatus.OK)
   public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData= service.downloadImage(fileName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
   }

}
