package com.psi.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psi.services.UserService;
import com.psi.models.User;


@Controller
public class RegisterController 
{
	
	@Autowired
	private UserService uService;
	User user = new User();
	
	@RequestMapping(value = "/formRegister", method = RequestMethod.POST)
	public String register(Model model, HttpServletRequest request) throws MessagingException
	{
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String notelp = request.getParameter("noTelp");
		String alamat = request.getParameter("alamat");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAlamat(alamat);
		user.setEmail(email);
		user.setNotelp(notelp);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		uService.saveOrUpdateUser(user);
		
		
		request.getSession().setAttribute("Username", user.getUsername());
		if(user.getRole().equals("User"))
		{
			return "redirect:/formLogin";
		}
		else if (user.getRole().equals("Vendor"))
		{
			return "redirect:/formLogin";
		}
		else if (user.getRole().equals("Pariwisata"))
		{
			return "redirect:/formLogin";
		}
		else
		{
			return "redirect:/HomeVendor";
		}
	}
	
	
	


	@RequestMapping("/rules")
	public String rules()
	{
		return "Rules";
	}
}
