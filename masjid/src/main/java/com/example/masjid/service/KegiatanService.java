package com.example.masjid.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.masjid.dto.KegiatanDto;
import com.example.masjid.entity.KegiatanEntity;
import com.example.masjid.repository.KegiatanRepository;
import com.example.masjid.util.FileDownloadUtil;
import com.example.masjid.util.FileUploadUtil;

import org.springframework.util.StringUtils;

@Service
public class KegiatanService {

	@Autowired
	private KegiatanRepository kegiatanRepository;
	
	@Transactional
	public Map<String, Object> addKegiatan(KegiatanDto kegiatanDto) throws IOException{
		
		String fileName = StringUtils.cleanPath(kegiatanDto.getFile().getOriginalFilename());
        long size = kegiatanDto.getFile().getSize();
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        String pathFile = "fileupload/" + "kegiatan/fotokegiatan/" + fileCode + "-" + fileName;
        
        FileUploadUtil.saveFile(fileName, "kegiatan", "", fileCode, kegiatanDto.getFile());
        
        KegiatanEntity kegiatanEntity = new KegiatanEntity();
        kegiatanEntity.setTitle(kegiatanDto.getTitle());
        kegiatanEntity.setDesc_kegiatan(kegiatanDto.getDesc_kegiatan());
        kegiatanEntity.setFile_code(fileCode);
        kegiatanEntity.setFile_name(fileName);
        kegiatanEntity.setPath(pathFile);
        kegiatanEntity.setSize(String.valueOf(size));
        kegiatanEntity.setTanggal_kegiatan(kegiatanDto.getTanggal_kegiatan());
        kegiatanEntity.setCreated_at(kegiatanDto.getCreated_at());
        kegiatanEntity.setUpdated_at("");
        
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("statusCode", 200);
		data.put("message", "Kegiatan berhasil ditambahkan");
		data.put("data", kegiatanRepository.save(kegiatanEntity));
		
		return data;
	}
	
	@Transactional
	public ResponseEntity<?> findKegiatan(String url) throws IOException{
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
}
