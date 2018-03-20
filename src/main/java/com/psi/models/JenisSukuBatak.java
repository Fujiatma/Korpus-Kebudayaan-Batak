package com.psi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jenisSukuBatak")
public class JenisSukuBatak {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int suku_id;

	@Column(nullable = false)
	private String nama_suku;

	@Column(nullable = true)
	private String daerah_asal;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artikel_id")
    private Artikel artikel;

	public JenisSukuBatak() {
		
	}

	public JenisSukuBatak(int suku_id, String nama_suku, String daerah_asal) {
		super();
		this.suku_id = suku_id;
		this.nama_suku = nama_suku;
		this.daerah_asal = daerah_asal;
	}

	public int getSuku_id() {
		return suku_id;
	}

	public void setSuku_id(int suku_id) {
		this.suku_id = suku_id;
	}

	public String getNama_suku() {
		return nama_suku;
	}

	public void setNama_suku(String nama_suku) {
		this.nama_suku = nama_suku;
	}

	public String getDaerah_asal() {
		return daerah_asal;
	}

	public void setDaerah_asal(String daerah_asal) {
		this.daerah_asal = daerah_asal;
	}
	


}
