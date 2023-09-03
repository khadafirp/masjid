package com.example.masjid.service;

import java.awt.TextArea;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.masjid.dto.PengurusDto;
import com.example.masjid.entity.PengurusEntity;
import com.example.masjid.repository.PengurusRepository;
import com.example.masjid.util.FileDownloadUtil;
import com.example.masjid.util.FileUploadUtil;

@Service
public class PengurusService {
	
	@Autowired
	private PengurusRepository pengurusRepository;
	
	@Transactional
	public Map<String, Object> showAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		
		ArrayList<String> dataArr = new ArrayList<String>();
		
		response.put("statusCode", 200);
		response.put("message", "sukses");
		response.put("data", pengurusRepository.findAll().isEmpty() ? dataArr : pengurusRepository.findAll());
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> add(PengurusDto pengurusDto) throws IOException{
		Map<String, Object> response = new HashMap<String, Object>();
		
		Optional<PengurusEntity> data = pengurusRepository.findById(pengurusDto.getId());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		PengurusEntity entry = new PengurusEntity();
		entry.setId(pengurusDto.getId());
		entry.setNama(pengurusDto.getNama());
		entry.setJabatan(pengurusDto.getJabatan());
		entry.setNik(pengurusDto.getNik());
		entry.setAlamat(pengurusDto.getAlamat());
		if(!pengurusDto.getFoto().isEmpty()) {
			String fileName = StringUtils.cleanPath(pengurusDto.getFoto().getOriginalFilename());
	        long size = pengurusDto.getFoto().getSize();
	        String fileCode = RandomStringUtils.randomAlphanumeric(8);
	        String pathFile = "http://localhost:1908/almuhajirin/pengurus/foto/" + fileCode + "-" + fileName;
	        
	        FileUploadUtil.saveFile(fileName, "pengurus", String.valueOf(pengurusDto.getId()), fileCode, pengurusDto.getFoto());
			
			entry.setFoto(pathFile);
		}
		entry.setCreated_at(formatter.format(now));
		entry.setUpdated_at(formatter.format(now));
			
		return response;
	}
	
	@Transactional
	public Map<String, Object> find(int id){
		Map<String, Object> response = new HashMap<String, Object>();
		
		Optional<PengurusEntity> data = pengurusRepository.findById(id);
		if(!data.isEmpty()) {
			response.put("statusCode", 200);
			response.put("message", "sukses");
		}else{
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		}
		
		response.put("data", data);
		
		return response;
	}
	
	@Transactional
	public ResponseEntity<?> findFoto(String url) throws IOException{
		FileDownloadUtil downloadUtil = new FileDownloadUtil();
        
        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(url);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
         
        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
         
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
         
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);       
	}
	
	@Transactional
	public Map<String, Object> edit(PengurusDto pengurusDto) throws IOException{
		Map<String, Object> response = new HashMap<String, Object>();
		
		Optional<PengurusEntity> data = pengurusRepository.findById(pengurusDto.getId());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		if(data.isEmpty()) {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		} else {
			PengurusEntity entry = new PengurusEntity();
			entry.setId(pengurusDto.getId());
			entry.setNama(pengurusDto.getNama());
			entry.setJabatan(pengurusDto.getJabatan());
			entry.setNik(pengurusDto.getNik());
			entry.setAlamat(pengurusDto.getAlamat());
			if(!pengurusDto.getFoto().isEmpty()) {
				String fileName = StringUtils.cleanPath(pengurusDto.getFoto().getOriginalFilename());
		        long size = pengurusDto.getFoto().getSize();
		        String fileCode = RandomStringUtils.randomAlphanumeric(8);
		        String pathFile = "http://localhost:1908/almuhajirin/pengurus/foto/" + fileCode + "-" + fileName;
		        
		        FileUploadUtil.saveFile(fileName, "pengurus", String.valueOf(pengurusDto.getId()), fileCode, pengurusDto.getFoto());
				
				entry.setFoto(pathFile);
			}
			entry.setUpdated_at(formatter.format(now));
		}
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> delete(int id){
		Map<String, Object> response = new HashMap<String, Object>();
		
		Optional<PengurusEntity> data = pengurusRepository.findById(id);
		
		if(data.isEmpty()) {
			response.put("statusCode", 404);
			response.put("message", "data tidak ditemukan.");
		} else {
			pengurusRepository.deleteById(id);
			response.put("statusCode", 200);
			response.put("message", "data berhasil dihapus.");
		}
		
		return response;
	}
}
