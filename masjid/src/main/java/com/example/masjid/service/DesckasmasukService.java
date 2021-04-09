package com.example.masjid.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masjid.entity.DesckasmasukEntity;
import com.example.masjid.repository.DesckasmasukRepository;

@Service
public class DesckasmasukService {
	
	@Autowired
	private DesckasmasukRepository desckasmasukRepository;
	
	@Transactional
	public Map<String, Object> addData(String desc_id, String desc){
		DesckasmasukEntity desckasmasukEntity = new DesckasmasukEntity();
		desckasmasukEntity.setDesc_id(desc_id);
		desckasmasukEntity.setDesc(desc);
		
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", 200);
		map.put("message", "success");
		map.put("data", desckasmasukRepository.save(desckasmasukEntity));
		
		return map;
	}
	
	@Transactional
	public Map<String, Object> filter(String desc_id){
		DesckasmasukEntity list = desckasmasukRepository.filter(desc_id);
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", 200);
		map.put("message", "success");
		map.put("data", list);
		
		return map;
	}

}
