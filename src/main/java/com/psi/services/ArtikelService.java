package com.psi.services;

import java.util.List;

import com.psi.models.Artikel;

public interface ArtikelService 
{
	List<Artikel> getAllTambahArtikelByStatus(String status);
	
	void updateStatusById(int id);
	
	List<Artikel> getAllArtikelById(Integer id);
	
	List<Artikel> getAllArtikelByJenisArtikel(String jenisinfo, String suku );
	
	public Artikel saveOrUpdateArtikel(Artikel artikel);
	
	public void deleteArtikel(int idArtikel);
	
	public Artikel getArtikelById(int idArtikel);
	
	public List<Artikel> getAllArtikel();
	
	public List<Artikel> getAllArtikelConfirm();
	
	void deleteArtikel(Integer id);
	
	List<Artikel> find(String judulartikel);
	
	Artikel find(int id);
	
	
}
