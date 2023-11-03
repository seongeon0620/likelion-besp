package com.woori.myapp.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@GetMapping("/file/upload")
	public String fileUpload() {
		return "/file/upload";
	}
	
	@Value("${fileUploadPath}")
	String  fileUploadPath;  //application.properties 파일에서 ${키값}

	@Value("${domain}")
	String  domain;

	@PostMapping("/upload")
	@ResponseBody
	public HashMap<String, Object> upload(MultipartFile file) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 이미 업로드시킨 파일은 임시경로에 올라와있다.
		String filename = file.getOriginalFilename();	// 본래파일명
		
		try {
			Path uploadPath = Paths.get(fileUploadPath);
			Path filePath = uploadPath.resolve(filename);
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		resultMap.put("filename", filename);
		resultMap.put("image_url", domain + "/" + fileUploadPath + "/" + filename);
		return resultMap;
	}
}
