package com.example.masjid.dto;

public class KasDto {
	
	int id, id_jenis_kas;
	String title_kas, nominal, created_at, updated_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_jenis_kas() {
		return id_jenis_kas;
	}
	public void setId_jenis_kas(int id_jenis_kas) {
		this.id_jenis_kas = id_jenis_kas;
	}
	public String getTitle_kas() {
		return title_kas;
	}
	public void setTitle_kas(String title_kas) {
		this.title_kas = title_kas;
	}
	public String getNominal() {
		return nominal;
	}
	public void setNominal(String nominal) {
		this.nominal = nominal;
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
