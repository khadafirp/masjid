package com.example.masjid.service;

import java.awt.TextArea;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masjid.entity.PengurusEntity;
import com.example.masjid.repository.PengurusRepository;

@Service
public class PengurusService {
	
	@SuppressWarnings("unused")
	@Autowired
	private PengurusRepository pengurusRepository;
	
	@Transactional
	public Map<String, Object> addUser(String login_id, String fullname, int nik, Date tgl_lahir, String tempat_lahir, String pendidikan, String email, String alamat_domisili, String no_hp, String pekerjaan){
		
		PengurusEntity pengurusEntity = new PengurusEntity();
		pengurusEntity.setLogin_id(login_id);
		pengurusEntity.setFullname(fullname);
		pengurusEntity.setNIK(nik);
		pengurusEntity.setTgl_lahir(tgl_lahir);
		pengurusEntity.setTempat_lahir(tempat_lahir);
		pengurusEntity.setPendidikan(pendidikan);
		pengurusEntity.setEmail(email);
		pengurusEntity.setAlamat_domisili(alamat_domisili);
		pengurusEntity.setNo_hp(no_hp);
		pengurusEntity.setPekerjaan(pekerjaan);
		
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", 200);
		map.put("message", "success");
		map.put("data", pengurusRepository.save(pengurusEntity));
		
		return map;
	}
	
	@Transactional
	public Map<String, Object> showAll(){
		
		List<PengurusEntity> list = pengurusRepository.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", 200);
		map.put("message", "success");
		map.put("data", list);
		
		return map;
	}
	
	@Transactional
	public Map<String, Object> filterPengurus(String login_id){
		PengurusEntity data = pengurusRepository.filter(login_id);
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", 200);
		map.put("message", "success");
		map.put("data", data);
		
		
		return map;
	}

}
