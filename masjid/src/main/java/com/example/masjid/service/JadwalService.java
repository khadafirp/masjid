package com.example.masjid.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.masjid.dto.JadwalDto;
import com.example.masjid.entity.JadwalEntity;
import com.example.masjid.repository.JadwalRepository;

@Service
public class JadwalService {

	@Autowired
	JadwalRepository jadwalRepository;
	
	@Transactional
	public Map<String, Object> showAllJadwal() {
		Map<String, Object> response = new HashMap<String, Object>();
		
		List<JadwalEntity> data = jadwalRepository.findAll();
				
		response.put("statusCode", 200);
		response.put("message", "sukses");
		response.put("data", data);
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> addJadwal(JadwalDto jadwalDto){
		Map<String, Object> response = new HashMap<String, Object>();
		JadwalEntity jadwalEntity = new JadwalEntity();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    Date date = new Date();
		
		if(
			!jadwalDto.getTitle_jadwal().isEmpty() &&
			!jadwalDto.getDesc_jadwal().isEmpty() &&
			!jadwalDto.getTanggal_jadwal().isEmpty()
		){
			jadwalEntity.setTitle_jadwal(jadwalDto.getTitle_jadwal());
			jadwalEntity.setDesc_jadwal(jadwalDto.getDesc_jadwal());
			jadwalEntity.setTanggal_jadwal(jadwalDto.getTanggal_jadwal());
			jadwalEntity.setCreated_at(formatter.format(date));
			jadwalEntity.setUpdated_at("");
			
			response.put("statusCode", 200);
			response.put("message", "sukses");
			response.put("data", jadwalRepository.save(jadwalEntity));
		}
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> findJadwal(int id){
		Map<String, Object> response = new HashMap<String, Object>();
		
		Optional<JadwalEntity> data = jadwalRepository.findById(id);
		
		if(data.isEmpty()) {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		} else {
			response.put("statusCode", 200);
			response.put("message", "sukses");
			response.put("data", data);
		}
		return response;
	}
	
	@Transactional
	public Map<String, Object> editJadwal(JadwalDto jadwalDto){
		Map<String, Object> response = new HashMap<String, Object>();
		JadwalEntity data = new JadwalEntity();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		
		if(!jadwalRepository.findById(jadwalDto.getId()).isEmpty()) {
			data.setTitle_jadwal(jadwalDto.getTitle_jadwal());
			data.setDesc_jadwal(jadwalDto.getDesc_jadwal());
			data.setTanggal_jadwal(jadwalDto.getTanggal_jadwal());
			data.setUpdated_at(formatter.format(date));
			
			if(
				!jadwalDto.getTitle_jadwal().isEmpty() &&
				!jadwalDto.getDesc_jadwal().isEmpty() &&
				!jadwalDto.getTanggal_jadwal().isEmpty()
			) {
				deleteJadwal(jadwalDto.getId());
				response.put("statusCode", 200);
				response.put("message", "sukses");
				response.put("data", jadwalRepository.save(data));
			}
		} else {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		}
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> deleteJadwal(int id){
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(!jadwalRepository.findById(id).isEmpty()) {
			jadwalRepository.deleteById(id);
			response.put("statusCode", 200);
			response.put("message", "data berhasil dihapus.");
		} else {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		}
		
		return response;
	}
}
