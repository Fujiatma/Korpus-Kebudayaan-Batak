package com.psi.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kategoriSumber")
public class KategoriSumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int kategori_id;

	@Column(nullable = false)
	private String jenis_kategori;

	@OneToMany(mappedBy = "kategoriSumber", cascade = CascadeType.ALL)
	private Set<Referensi> referensis;

	public KategoriSumber() {

	}

	public KategoriSumber(int kategori_id, String jenis_kategori) {
		super();
		this.kategori_id = kategori_id;
		this.jenis_kategori = jenis_kategori;
	}

	public int getKategori_id() {
		return kategori_id;
	}

	public void setKategori_id(int kategori_id) {
		this.kategori_id = kategori_id;
	}

	public String getJenis_kategori() {
		return jenis_kategori;
	}

	public void setJenis_kategori(String jenis_kategori) {
		this.jenis_kategori = jenis_kategori;
	}

}
