package com.psi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psi.services.UserService;
import com.psi.models.User;

@Repository
public class UserDao implements UserService {
	private EntityManagerFactory emf;
	
	private PasswordDao passwords;
	
	
	public PasswordDao getPasswords() {
		return passwords;
	}

	@Autowired
	public void setPasswords(PasswordDao passwords) {
		this.passwords = passwords;
	}

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public User getUserById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(User.class, id);
	}

	@Override
	public User saveOrUpdateUser(User user) {
		System.out.println("->>"+user.getPassword());
		String hashedPassword = passwords.encode(user.getPassword());
		user.setPassword(hashedPassword);
		System.out.println("->>"+user.getPassword());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		User us = (User) user;
		System.out.println("Keluarr");
		return us;
		
	}
	@Override
	public void deleteUser(String username) {
		EntityManager em = emf.createEntityManager();
		User user = (User) getUserByUsername(username);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		for (User u : getAllUser()) {
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User LoginUser(String username, String password) {
		List<User> users = getAllUser();
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUsername().equals(username)){
				if(passwords.matches(password, users.get(i).getPassword()))
					return users.get(i);
				else return null;
			}
		}
		return null;
		
	}

}
