package com.example.masjid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.dto.JadwalDto;
import com.example.masjid.entity.JadwalEntity;
import com.example.masjid.service.JadwalService;

@Controller
@RequestMapping("/jadwal")
public class JadwalController {

	@Autowired
	JadwalService jadwalService;
	
	@GetMapping("/all")
	@ResponseBody
	public Map<String, Object> showAll(){
		return jadwalService.showAllJadwal();
	}
	
	@PostMapping("/find")
	@ResponseBody
	public Map<String, Object> find(@RequestBody JadwalDto jadwalDto){
		return jadwalService.findJadwal(jadwalDto.getId());
	}
	
	@PostMapping("/edit")
	@ResponseBody
	public Map<String, Object> edit(@RequestBody JadwalDto jadwalDto){
		return jadwalService.editJadwal(jadwalDto);
	}
	
	@PostMapping("/delete")
	public Map<String, Object> delete(@RequestBody JadwalDto jadwalDto){
		return jadwalService.deleteJadwal(jadwalDto.getId());
	}
}
