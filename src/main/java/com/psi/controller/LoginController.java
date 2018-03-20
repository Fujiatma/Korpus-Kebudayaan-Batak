package com.psi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psi.services.ArtikelService;
import com.psi.models.User;
import com.psi.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private ArtikelService artikelService;
	@Autowired
	private UserService uService;


	@Autowired
	public void setArtikelService(ArtikelService artikelService) {
		this.artikelService = artikelService;
	}

	
	private User user;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user = (User) uService.LoginUser(username, password);
		if (user != null) {
			if (user.getRole().equals("User")) {
				request.getSession().setAttribute("user", user.getId());
				request.getSession().setAttribute("name", user.getFullname());
				request.getSession().setAttribute("idUser", user.getId());
				request.getSession().setAttribute("User", true);
				request.getSession().setAttribute("Vendor", false);
				request.getSession().setAttribute("Pariwisata", false);
				return "redirect:/";
			} else if (user.getRole().equals("Vendor")) {
				request.getSession().setAttribute("user", user.getId());
				request.getSession().setAttribute("name", user.getFullname());
				request.getSession().setAttribute("vendor", user.getId());
				request.getSession().setAttribute("User", false);
				request.getSession().setAttribute("Vendor", true);
				request.getSession().setAttribute("Pariwisata", false);
				return "redirect:/HomeVendor";
			}else if (user.getRole().equals("Pariwisata"))
			{
				request.getSession().setAttribute("user", user.getId());
				request.getSession().setAttribute("name", user.getFullname());
				request.getSession().setAttribute("pariwisata", user.getId());
				request.getSession().setAttribute("User", false);
				request.getSession().setAttribute("Vendor", false);
				request.getSession().setAttribute("Pariwisata", true);
				return "redirect:/HomePariwisata";
			}
		}
		return "redirect:/formLogin";
	}

	public UserService getuService() {
		return uService;
	}

	@Autowired
	public void setuService(UserService uService) {
		this.uService = uService;
	}

	public ArtikelService getArtikelService() {
		return artikelService;
	}

	@Autowired
	public void setInfoDao(ArtikelService artikelService) {
		this.artikelService= artikelService;
	}
	

	
}
