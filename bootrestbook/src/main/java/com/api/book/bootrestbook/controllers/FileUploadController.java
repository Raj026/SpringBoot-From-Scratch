package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());
        // System.out.println(file.getClass());

        //if file is empty
        if(file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }

        //check for the type of the file
        if(!file.getContentType().equals("image/png")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only PNG files are allowed");           
        }

        //file upload code
        
        try {
            boolean f = fileUploadHelper.uploadFile(file);
            if (!f) {
                return ResponseEntity.status(HttpStatus.OK).body("File is successfully uploaded");
            }
                
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
