package com.psi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int log_id;

	private String update_by;
	private String jenis_suku_log;
	private String konten_log;
	private String lokasi_log;
	private String keyword_log;
	private Date modified_date_log;
	private String judul_log;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artikel_id")
	private Artikel artikel;

	public Log() {
	}

	public Log(int log_id, String update_by, String jenis_suku_log, String konten_log, String lokasi_log,
			String keyword_log, Date modified_date_log, String judul_log) {
		super();
		this.log_id = log_id;
		this.update_by = update_by;
		this.jenis_suku_log = jenis_suku_log;
		this.konten_log = konten_log;
		this.lokasi_log = lokasi_log;
		this.keyword_log = keyword_log;
		this.modified_date_log = modified_date_log;
		this.judul_log = judul_log;
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public String getJenis_suku_log() {
		return jenis_suku_log;
	}

	public void setJenis_suku_log(String jenis_suku_log) {
		this.jenis_suku_log = jenis_suku_log;
	}

	public String getKonten_log() {
		return konten_log;
	}

	public void setKonten_log(String konten_log) {
		this.konten_log = konten_log;
	}

	public String getLokasi_log() {
		return lokasi_log;
	}

	public void setLokasi_log(String lokasi_log) {
		this.lokasi_log = lokasi_log;
	}

	public String getKeyword_log() {
		return keyword_log;
	}

	public void setKeyword_log(String keyword_log) {
		this.keyword_log = keyword_log;
	}

	public Date getModified_date_log() {
		return modified_date_log;
	}

	public void setModified_date_log(Date modified_date_log) {
		this.modified_date_log = modified_date_log;
	}

	public String getJudul_log() {
		return judul_log;
	}

	public void setJudul_log(String judul_log) {
		this.judul_log = judul_log;
	}

}
