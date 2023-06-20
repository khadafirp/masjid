package com.example.masjid.dto;

import org.springframework.web.multipart.MultipartFile;

public class KegiatanDto {

	String title, desc_kegiatan, path, size, tanggal_kegiatan, created_at, updated_at;
	MultipartFile file;
	
//	public KegiatanDto(String title,
//			String desc_kegiatan,
//			String path,
//			String size,
//			String tanggal_kegiatan,
//			String created_at,
//			String updated_at) {
//		this.title = title;
//		this.desc_kegiatan = desc_kegiatan;
//		this.path = path;
//		this.size = size;
//		this.tanggal_kegiatan = tanggal_kegiatan;
//		this.created_at = created_at;
//		this.updated_at = updated_at;
//	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc_kegiatan() {
		return desc_kegiatan;
	}

	public void setDesc_kegiatan(String desc_kegiatan) {
		this.desc_kegiatan = desc_kegiatan;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTanggal_kegiatan() {
		return tanggal_kegiatan;
	}

	public void setTanggal_kegiatan(String tanggal_kegiatan) {
		this.tanggal_kegiatan = tanggal_kegiatan;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}
