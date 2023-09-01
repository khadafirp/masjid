package com.example.masjid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "jadwal")
public class JadwalEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	int id;
	
	@Column(name = "title_jadwal")
	String title_jadwal;
	
	@Column(name = "desc_jadwal")
	String desc_jadwal;
	
	@Column(name = "tanggal_jadwal")
	String tanggal_jadwal;
	
	@Column(name = "created_at")
	String created_at;
	
	@Column(name = "updated_at")
	String updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle_jadwal() {
		return title_jadwal;
	}

	public void setTitle_jadwal(String title_jadwal) {
		this.title_jadwal = title_jadwal;
	}

	public String getDesc_jadwal() {
		return desc_jadwal;
	}

	public void setDesc_jadwal(String desc_jadwal) {
		this.desc_jadwal = desc_jadwal;
	}

	public String getTanggal_jadwal() {
		return tanggal_jadwal;
	}

	public void setTanggal_jadwal(String tanggal_jadwal) {
		this.tanggal_jadwal = tanggal_jadwal;
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
