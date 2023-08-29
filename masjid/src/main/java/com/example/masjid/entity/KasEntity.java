package com.example.masjid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_kas")
public class KasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_jenis_kas")
	private int id_jenis_kas;
	
	@Column(name = "title_kas")
	private String title_kas;

	@Column(name = "nominal")
	private String nominal;
	
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
