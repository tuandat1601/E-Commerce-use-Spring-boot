package com.bootcamp.library.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUpload {
	private final String UPLOAD_FOLDER = "D:\\MY_PROJECT\\E-Commerce\\ecommerce\\admin\\fileUpload";
	    public boolean uploadFile(MultipartFile file) {
	        boolean isUpload = false;
	        try {
	            Files.copy(file.getInputStream(), Paths.get(UPLOAD_FOLDER + File.separator + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
	            isUpload = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isUpload;
	    }

	    public boolean checkExist(MultipartFile multipartFile){
	        boolean isExist = false;
	        try {
	           File file = new File(UPLOAD_FOLDER +"\\" + multipartFile.getOriginalFilename());
	           isExist = file.exists();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return isExist;
	    }
}
