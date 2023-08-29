package com.example.masjid.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masjid.dto.KasDto;
import com.example.masjid.entity.KasEntity;
import com.example.masjid.repository.KasRepository;

import io.jsonwebtoken.io.IOException;

@Service
public class KasService {
	
	@Autowired
	private KasRepository kasRepository;
	
	@Transactional
	public Map<String, Object> showJenis(){
		List<KasEntity> data = kasRepository.findAll();
		
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

	@Transactional
	public Map<String, Object> addKas(KasDto kasDto) throws IOException{
		Map<String, Object> response = new HashMap<String, Object>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		KasEntity kasEntity = new KasEntity();
		if(
			!String.valueOf(kasDto.getId_jenis_kas()).isEmpty() &&
			!kasDto.getTitle_kas().isEmpty() &&
			!kasDto.getNominal().isEmpty()
		) {
			kasEntity.setId_jenis_kas(kasDto.getId_jenis_kas());
			kasEntity.setTitle_kas(kasDto.getTitle_kas());
			kasEntity.setNominal(kasDto.getNominal());
			kasEntity.setCreated_at(dtf.format(now));
			kasEntity.setUpdated_at(dtf.format(now));
			
			response.put("statusCode", 200);
			response.put("message", "sukses");
			response.put("data", kasRepository.save(kasEntity));
		}
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> findKas(int id) throws IOException{
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(!kasRepository.findById(id).isEmpty()) {
			response.put("statusCode", 200);
			response.put("message", "sukses");
			response.put("data", kasRepository.findById(id));
		} else {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan");
		}
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> editKas(KasDto kasDto) throws IOException{
		Map<String, Object> response = new HashMap<String, Object>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		Map<String, Object> dataKas = findKas(kasDto.getId());
		if(dataKas.get("statusCode").equals(200)) {
			kasRepository.deleteById(kasDto.getId());
			
			KasEntity kasEntity = new KasEntity();
			kasEntity.setId(kasDto.getId());
			kasEntity.setId_jenis_kas(kasDto.getId_jenis_kas());
			kasEntity.setTitle_kas(kasDto.getTitle_kas());
			kasEntity.setNominal(kasDto.getNominal());
			kasEntity.setCreated_at(kasDto.getCreated_at());
			kasEntity.setUpdated_at(dtf.format(now));
			
			response.put("statusCode", 200);
			response.put("message", "sukses");
			response.put("data", kasRepository.save(kasEntity));
		}
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> deleteKas(int id) throws IOException{
		Map<String, Object> response = new HashMap<String, Object>();
		if(!kasRepository.findById(id).isEmpty()) {
			kasRepository.deleteById(id);
			response.put("statusCode", 200);
			response.put("message", "data berhasil dihapus.");
		}else {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		}
		
		return response;
	}
}
