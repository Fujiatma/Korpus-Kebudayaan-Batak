package com.psi.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psi.services.ArtikelService;

@Controller
public class HomeController 
{
	@Autowired
	private ArtikelService artikelService;
	

	@RequestMapping("/Home")
	public String home(Model model, HttpServletRequest request)
	{
		model.addAttribute("artikel", artikelService.getAllArtikel());
		return "Home";
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request)
	{
		request.getSession().removeAttribute("vendor");
		request.getSession().removeAttribute("pariwisata");
		request.getSession().removeAttribute("user");
		request.getSession().setAttribute("User", false);
		request.getSession().setAttribute("Vendor", false);
		request.getSession().setAttribute("Pariwisata", false);
		return "redirect:/";
	}
	
	@RequestMapping(value = {"/artikel/{id}"}, method = RequestMethod.GET)
    public String artikel(Model model,Principal p, @PathVariable int id){    	    	
		model.addAttribute("artikel", artikelService.find(id));
    	return "MoreUser";
    }
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String homeLogin(org.apache.catalina.servlet4preview.http.HttpServletRequest request)
	{
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		return"redirect:/";
	}
}
