package com.example.masjid.dto;

public class JadwalDto {

	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String title_jadwal, desc_jadwal, tanggal_jadwal, created_at, updated_at;

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
