package com.example.masjid.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.dto.KasDto;
import com.example.masjid.service.KasService;

import io.jsonwebtoken.io.IOException;

@Controller
@RequestMapping("/kas")
public class KasController {
	
	@Autowired
	private KasService kasService;

	@GetMapping("/show")
	@ResponseBody
	public Map<String, Object> showAll(){
		Map<String, Object> map = kasService.showJenis();
		return map;
	}
	
	@PostMapping("/addKas")
	@ResponseBody
	public Map<String, Object> addKas(@RequestParam(name = "id_jenis_kas") int id_jenis_kas,
			@RequestParam(name = "title_kas") String title_kas,
			@RequestParam(name = "nominal") String nominal){
		KasDto kasDtoNew = new KasDto();
		kasDtoNew.setId_jenis_kas(id_jenis_kas);
		kasDtoNew.setTitle_kas(title_kas);
		kasDtoNew.setNominal(nominal);
				
		return kasService.addKas(kasDtoNew);
	}
	
	@PostMapping("/editKas")
	@ResponseBody
	public Map<String, Object> editKas(
		@RequestParam(name = "id") int id,
		@RequestParam(name = "id_jenis_kas") int id_jenis_kas,
		@RequestParam(name = "title_kas") String title_kas,
		@RequestParam(name = "nominal") String nominal,
		@RequestParam(name = "created_at") String created_at
	){
		KasDto kasDto = new KasDto();
		kasDto.setId(id);
		kasDto.setId_jenis_kas(id_jenis_kas);
		kasDto.setTitle_kas(title_kas);
		kasDto.setNominal(nominal);
		kasDto.setCreated_at(created_at);
		
		return kasService.editKas(kasDto);
	}
	
	@GetMapping("/findKas")
	@ResponseBody
	public Map<String, Object> findKas(int id){
		return kasService.findKas(id);
	}
	
	@PostMapping("/deleteKas")
	@ResponseBody
	public Map<String, Object> deleteKas(int id){
		return kasService.deleteKas(id);
	}
}
