package com.lmr.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping("/view")
	public String view(){
		return "file/load";
	}

	@RequestMapping(value="/load", method=RequestMethod.POST)
	public String load(@RequestParam("fileload")MultipartFile file,Model model) throws IOException{
		
		System.out.println(file.getOriginalFilename());
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\Text\\", System.currentTimeMillis()+ file.getOriginalFilename()));
		
		model.addAttribute("filename", file.getOriginalFilename());
		
		return "file/result";
	}
	
	@RequestMapping(value="/load1", method=RequestMethod.POST)
	public String load1(MultipartHttpServletRequest multipartRequest,Model model) throws IOException{
		
		Map<String,MultipartFile> filemap=multipartRequest.getFileMap();
		
		for(Entry<String, MultipartFile> en:filemap.entrySet()){
			System.out.println(en.getKey()+" - - "+en.getValue().getOriginalFilename());
			FileUtils.copyInputStreamToFile(en.getValue().getInputStream(), new File("D:\\Text\\", System.currentTimeMillis()+ en.getValue().getOriginalFilename()));
		}
		
		return "file/result";
	}
	
}
