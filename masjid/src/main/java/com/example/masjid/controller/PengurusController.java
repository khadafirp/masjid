package com.example.masjid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/addUser")
	@ResponseBody
	public Map<String, Object> addUser(
			@RequestBody PengurusEntity pengurusEntity
	){
		
		Map<String, Object> map = pengurusService.addUser(
				pengurusEntity.getLogin_id(), 
				pengurusEntity.getFullname(), 
				pengurusEntity.getNIK(), 
				pengurusEntity.getTgl_lahir(), 
				pengurusEntity.getTempat_lahir(), 
				pengurusEntity.getPendidikan(), 
				pengurusEntity.getEmail(), 
				pengurusEntity.getAlamat_domisili(), 
				pengurusEntity.getNo_hp(), 
				pengurusEntity.getPekerjaan());
		
		return map;
		
	}

	@GetMapping("/showAllUser")
	@ResponseBody
	public Map<String, Object> showAllUser(){
		Map<String, Object> data = pengurusService.showAll();
		
		return data;
	}
	
	@GetMapping("filterPengurus")
	@ResponseBody
	public Map<String, Object> filterPengurus(@RequestBody PengurusEntity pengurusEntity){
		Map<String, Object> map = pengurusService.filterPengurus(pengurusEntity.getLogin_id());
		return map;
	}
}
