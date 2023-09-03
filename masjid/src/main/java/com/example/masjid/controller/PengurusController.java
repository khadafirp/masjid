package com.example.masjid.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.dto.PengurusDto;
import com.example.masjid.entity.PengurusEntity;
import com.example.masjid.repository.PengurusRepository;
import com.example.masjid.service.PengurusService;

@Controller
@RequestMapping("/pengurus")
public class PengurusController {
	
	public PengurusController() {
		
	}
	
	@Autowired
	private PengurusService pengurusService;
	
	@GetMapping("/showAll")
	@ResponseBody
	private Map<String, Object> showAll(){
		return pengurusService.showAll();
	}
	
	@PostMapping("/add")
	@ResponseBody
	private Map<String, Object> add(PengurusDto pengurusDto) throws IOException{
		return pengurusService.add(pengurusDto);
	}
	
	@PostMapping("/edit")
	@ResponseBody
	private Map<String, Object> edit(PengurusDto pengurusDto) throws IOException{
		return pengurusService.edit(pengurusDto);
	}
	
	@GetMapping("/foto/{url}")
	@ResponseBody
	public ResponseEntity<?> downloadFoto(@PathVariable("url") String url) throws IOException{
		return pengurusService.findFoto(url);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	private Map<String, Object> delete(PengurusDto pengurusDto){
		return pengurusService.delete(pengurusDto.getId());
	}
}
