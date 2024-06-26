package com.api.book.bootrestbook.helper;

import java.io.File;
// import java.io.FileOutputStream;
// import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public String UPLOAD_DIR="C:\\Users\\RAJ\\Desktop\\Springboot\\bootrestbook\\src\\main\\resources\\static";
    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f =false;
        try {
            //
            // InputStream is = multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // //write 
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();
            // f=true;

            //alternative approach to get input file and middle param is for where to store it and third param is for replace existing file if any
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + File.separator
                    + multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
