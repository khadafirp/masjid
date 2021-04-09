package com.example.masjid.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masjid.entity.JeniskasEntity;
import com.example.masjid.repository.JeniskasRepository;

@Service
public class JeniskasService {
	
	@Autowired
	private JeniskasRepository jeniskasRepository;
	
	@Transactional
	public Map<String, Object> showJenis(){
		List<JeniskasEntity> data = jeniskasRepository.findAll();
		
		Map<String, Object> map = new HashMap<>();
		
		if(data.isEmpty()) {
			map.put("statusCode", 400);
			map.put("message", "data is null");
		}else {
			map.put("statusCode", 200);
			map.put("message", "success");
			map.put("data", data);
		}
		
		return map;
	}

}
