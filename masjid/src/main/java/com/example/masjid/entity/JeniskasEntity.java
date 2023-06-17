package com.example.masjid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jenis_kas")
public class JeniskasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "jenis_kas_id")
	private String jenis_kas_id;
	
	@Column(name = "jenis")
	private String jenis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJenis_kas_id() {
		return jenis_kas_id;
	}

	public void setJenis_kas_id(String jenis_kas_id) {
		this.jenis_kas_id = jenis_kas_id;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
}
