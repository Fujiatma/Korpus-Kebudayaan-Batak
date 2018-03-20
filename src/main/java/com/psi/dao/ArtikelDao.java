package com.psi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psi.services.ArtikelService;
import com.psi.models.Artikel;

@Repository
public class ArtikelDao implements ArtikelService
{
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory emf)
	{
		this.emf = emf;
	}

	@Override
	public Artikel saveOrUpdateArtikel(Artikel artikel) 
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Artikel saved = em.merge(artikel);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public void deleteArtikel(int idArtikel) 
	{
		EntityManager em = emf.createEntityManager();
		Artikel artikel = (Artikel) getArtikelById(idArtikel);
		em.getTransaction().begin();
		em.remove(artikel);
		em.getTransaction().commit();
	}

	@Override
	public Artikel getArtikelById(int idArtikel) 
	{
		EntityManager em = emf.createEntityManager();
		return em.find(Artikel.class, idArtikel);
	}

	@Override
	public List<Artikel> getAllArtikel() 
	{
		EntityManager em = emf.createEntityManager();
		List<Artikel> test = em.createQuery("from Artikel" , Artikel.class).getResultList();
		return test;
	}

	@Override
	public List<Artikel> getAllArtikelConfirm() {
		EntityManager em = emf.createEntityManager();
		List<Artikel> test = em.createQuery("from Artikel where status='Confirm'" , Artikel.class).getResultList();
		return test;
	}
	
	@Override
	public void deleteArtikel(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Artikel.class, id));
		em.getTransaction().commit();
	}

	@Override
	public Artikel find(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Artikel.class, id);
	}

	@Override
	public List<Artikel> getAllTambahArtikelByStatus(String status) {
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("from Artikel where status='"+status+"'", Artikel.class).getResultList();
	}

	@Override
	public void updateStatusById(int id) {
		Artikel artikel = find(id);
		artikel.setStatus("YES");
		artikel = saveOrUpdateArtikel(artikel);
	}

	@Override
	public List<Artikel> getAllArtikelById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("from Artikel where iduser="+id, Artikel.class).getResultList();
	
	}

	@Override
	public List<Artikel> getAllArtikelByJenisArtikel(String jenisartikel, String suku) {
		EntityManager em = emf.createEntityManager();
		List<Artikel> test = em.createQuery("from Artikel where jenisartikel='"+jenisartikel+"'and suku='"+suku+"'" , Artikel.class).getResultList();
		System.out.println(test.size());
		return test;
		}
	

	@Override
	public List<Artikel> find(String judulartikel) {
		judulartikel = "%"+judulartikel+"%";
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Artikel where judulartikel like'"+judulartikel+"' or isiartikel like '"+judulartikel+"'", Artikel.class).getResultList();		
	}

	

}
