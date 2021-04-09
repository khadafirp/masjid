package com.example.masjid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.service.JeniskasService;

@Controller
@RequestMapping("/jeniskas")
public class JeniskasController {
	
	@Autowired
	private JeniskasService JeniskasService;

	@GetMapping("/show")
	@ResponseBody
	public Map<String, Object> showAll(){
		Map<String, Object> map = JeniskasService.showJenis();
		return map;
	}
}
