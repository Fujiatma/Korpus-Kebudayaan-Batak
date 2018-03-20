package com.psi.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "referensi")
public class Referensi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int referensi_id;

	private String url;
	private String tahun;
	private String judul;
	private String pengarang;
	private String jenis_sumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artikel_id")
	private Artikel artikel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kategoriSumber_id")
	private KategoriSumber kategoriSumber;

	public Referensi() {

	}

	public Referensi(int referensi_id, String url, String tahun, String judul, String pengarang, String jenis_sumber) {
		super();
		this.referensi_id = referensi_id;
		this.url = url;
		this.tahun = tahun;
		this.judul = judul;
		this.pengarang = pengarang;
		this.jenis_sumber = jenis_sumber;
	}

	public int getReferensi_id() {
		return referensi_id;
	}

	public void setReferensi_id(int referensi_id) {
		this.referensi_id = referensi_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getPengarang() {
		return pengarang;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}

	public String getJenis_sumber() {
		return jenis_sumber;
	}

	public void setJenis_sumber(String jenis_sumber) {
		this.jenis_sumber = jenis_sumber;
	}

}
