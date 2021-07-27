package com.project.api;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/loadfile")
public class Uploadfile {
	@Autowired
	ServletContext app;
	@PostMapping("/upload")
	public String PostUploadFile(@RequestParam("imgUrl") MultipartFile attach)
				throws IllegalStateException, IOException {
		String fileName = attach.getOriginalFilename();
		File file = new File(app.getRealPath("/home/img"+fileName));
		attach.transferTo(file);
		System.out.println(file+"********");
		return fileName;
	}
}
