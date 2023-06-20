package com.example.masjid.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.masjid.dto.KegiatanDto;
import com.example.masjid.service.KegiatanService;

@Controller
@RequestMapping("/kegiatan")
public class KegiatanController {
	
	public KegiatanController() {
		
	}
	
	@Autowired
	private KegiatanService kegiatanService;
	
	@PostMapping(value = "/test")
	@ResponseBody
	public Map<String, Object> test(
		@RequestParam(value = "title") String title,
		@RequestParam(value = "desc_kegiatan") String desc_kegiatan,
		@RequestParam(value = "file", required = true) MultipartFile file,
		@RequestParam(value = "tanggal_kegiatan") String tanggal_kegiatan
	) throws IOException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    Date date = new Date();
		
		KegiatanDto data = new KegiatanDto();
		data.setTitle(title);
		data.setDesc_kegiatan(desc_kegiatan);
		data.setFile(file);
		data.setTanggal_kegiatan(tanggal_kegiatan);
		data.setCreated_at(formatter.format(date));
		
		Map<String, Object> map = kegiatanService.addKegiatan(data);
		
		return map;
	}
	
	@GetMapping("/foto/{url}")
	@ResponseBody
	public Map<String, Object> downloadFoto(@PathVariable("url") String url) throws IOException{
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("statusCode", HttpStatus.OK);
		response.put("message", "success");
		response.put("data", kegiatanService.findKegiatan(url));
		
		return response;
	}
}
