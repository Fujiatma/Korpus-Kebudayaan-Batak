package com.psi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artikel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String judulartikel;
	private Integer iduser;
	private String isiartikel;
	private String lokasi;
	private String suku;
	private String referensi;
	private String keyword;
	private String gambar;
	private String status;
	private String jenisartikel;
	
	public Artikel(int id, String judulartikel, String isiartikel, String lokasi, String suku,String referensi, String keyword, String status, String jenisartikel ) {
		super();
		this.id = id;
		this.judulartikel= judulartikel;
		this.isiartikel = isiartikel;
		this.lokasi = lokasi;
		this.suku = suku;
		this.referensi = referensi;
		this.keyword = keyword;
		this.status = status;
		this.jenisartikel = jenisartikel;
	}
	
	
	

	/**
	 * @return the jenisartikel
	 */
	public String getJenisartikel() {
		return jenisartikel;
	}

	/**
	 * @param jenisartikel the jenisartikel to set
	 */
	public void setJenisartikel(String jenisartikel) {
		this.jenisartikel = jenisartikel;
	}




	/**
	 * @return the iduser
	 */
	public Integer getIduser() {
		return iduser;
	}



	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJudulartikel() {
		return judulartikel;
	}

	public void setJudulartikel(String judulartikel) {
		this.judulartikel = judulartikel;
	}

	public String getIsiartikel() {
		return isiartikel;
	}

	public void setIsiartikel(String isiartikel) {
		this.isiartikel = isiartikel;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public String getSuku() {
		return suku;
	}

	public void setSuku(String suku) {
		this.suku = suku;
	}

	public String getReferensi() {
		return referensi;
	}

	public void setReferensi(String referensi) {
		this.referensi = referensi;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Artikel()
	{	
	}
	
	public String getGambar() {
		return gambar;
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
