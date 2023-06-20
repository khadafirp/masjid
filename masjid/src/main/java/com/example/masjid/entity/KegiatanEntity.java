package com.example.masjid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_kegiatan")
public class KegiatanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "desc_kegiatan")
	private String desc_kegiatan;
	
	@Column(name = "file_code")
	private String file_code;
	
	public String getFile_code() {
		return file_code;
	}

	public void setFile_code(String file_code) {
		this.file_code = file_code;
	}

	@Column(name = "file_name")
	private String file_name;

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	@Column(name = "path")
	private String path;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "tanggal_kegiatan")
	private String tanggal_kegiatan;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
