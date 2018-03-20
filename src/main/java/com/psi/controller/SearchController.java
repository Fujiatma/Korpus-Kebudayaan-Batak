package com.psi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psi.services.ArtikelService;


@Controller
public class SearchController {
	
	@Autowired
	private ArtikelService artikelService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String SearchByKeyword(Model model, HttpServletRequest request){
		String judulartikel = request.getParameter("judulartikel");
		model.addAttribute("search", judulartikel);
		model.addAttribute("artikel", artikelService.find(judulartikel));
		
		return "indexSearch";
	}
	
	
}