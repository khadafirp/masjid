package com.example.masjid.entity;

import java.awt.TextArea;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "masjid_user")
public class PengurusEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "login_id")
	private String login_id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "NIK")
	private int NIK;
	
	@Column(name = "tgl_lahir")
	private Date tgl_lahir;
	
	@Column(name = "tempat_lahir")
	private String tempat_lahir;
	
	@Column(name = "pendidikan")
	private String pendidikan;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "alamat_domisili")
	private String alamat_domisili;
	
	@Column(name = "no_hp")
	private String no_hp;
	
	@Column(name = "pekerjaan")
	private String pekerjaan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getNIK() {
		return NIK;
	}

	public void setNIK(int nIK) {
		NIK = nIK;
	}

	public Date getTgl_lahir() {
		return tgl_lahir;
	}

	public void setTgl_lahir(Date tgl_lahir) {
		this.tgl_lahir = tgl_lahir;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public String getPendidikan() {
		return pendidikan;
	}

	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlamat_domisili() {
		return alamat_domisili;
	}

	public void setAlamat_domisili(String alamat_domisili) {
		this.alamat_domisili = alamat_domisili;
	}

	public String getNo_hp() {
		return no_hp;
	}

	public void setNo_hp(String no_hp) {
		this.no_hp = no_hp;
	}

	public String getPekerjaan() {
		return pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

}
