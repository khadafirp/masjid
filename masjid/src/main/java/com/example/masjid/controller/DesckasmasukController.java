package com.example.masjid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.entity.DesckasmasukEntity;
import com.example.masjid.service.DesckasmasukService;

@Controller
@RequestMapping("/desckasmasuk")
public class DesckasmasukController {
	
	@Autowired
	private DesckasmasukService desckasmasukService;
	
	@PostMapping("addDesckasmasuk")
	@ResponseBody
	public Map<String, Object> addDesc(@RequestBody DesckasmasukEntity desckasmasukEntity){
		Map<String, Object> map = desckasmasukService.addData(desckasmasukEntity.getDesc_id(), desckasmasukEntity.getDesc());
		return map;
	}
	
	@PostMapping("filter")
	@ResponseBody
	public Map<String, Object> filter(@RequestBody DesckasmasukEntity desckasmasukEntity){
		Map<String, Object> data = desckasmasukService.filter(
			desckasmasukEntity.getDesc_id()
		);
		
		return data;
	}
}
