package com.psi.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psi.models.User;
import com.psi.services.ArtikelService;
import com.psi.services.UserService;

@Controller
public class WelcomeController {
	@Autowired
	private ArtikelService bService;
	@Autowired
	private UserService uService;

	@RequestMapping(value = {"/artikelll/{id}"}, method = RequestMethod.GET)
    public String artikel(Model model,Principal p, @PathVariable int id){    	    	
		model.addAttribute("artikel", bService.find(id));
    	return "MoreNonUser";
    }	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request, Model model) {
		if(Boolean.parseBoolean(""+request.getSession().getAttribute("Vendor")) == true){
			return "redirect:/HomeVendor";
		}
		else if(Boolean.parseBoolean(""+request.getSession().getAttribute("Pariwisata")) == true){
			return "redirect:/HomePariwisata";
		}
		model.addAttribute("namaUser", (String) request.getSession().getAttribute("username"));
		if (request.getSession().getAttribute("user") != null) {
			model.addAttribute("listHome", bService.getAllArtikelConfirm());
			User user = (User) uService
					.getUserById(Integer.parseInt(request.getSession().getAttribute("user").toString()));
			if (user.getRole().equals("User")) {
				model.addAttribute("allArtikel", bService.getAllArtikelConfirm());
				model.addAttribute("username", (Integer) request.getSession().getAttribute("user"));
				model.addAttribute("name", (String) request.getSession().getAttribute("name"));
				return "Home";
			} else
				return "redirect:/formLogin";
		} else {
			model.addAttribute("allArtikel", bService.getAllArtikelConfirm());
			return "Welcome";
		}
	}

	
	@RequestMapping ("/NonUserJenisTarian/{jenis}")
	public String jenisTarianNonUser(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Tarian","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Tarian","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Tarian","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Tarian","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Tarian","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Tarian","Batak Angkola"));
		}
		return "NonUserJenisTarian";		
	}
	@RequestMapping ("/NonUserJenisMusik/{jenis}")
	public String jenisMusikNonUser(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Musik","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Musik","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Musik","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Musik","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Musik","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Musik","Batak Angkola"));
		}
		return "NonUserJenisMusik";		
	}

	@RequestMapping ("/NonUserJenisLainya/{jenis}")
	public String jenisLainya(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Lainya","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Lainya","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Lainya","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Lainya","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Lainya","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Lainya","Batak Angkola"));
		}
		return "NonUserJenisLainya";		
	}

	@RequestMapping ("/NonUserJenisBendaBersejarah/{jenis}")
	public String jenisBendaBersejarahNonUser(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Angkola"));
		}
		return "NonUserJenisBendaBersejarah";		
	}

	@RequestMapping ("/NonUserJenisMakanan/{jenis}")
	public String jenisJenisMakananNonUser(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Makanan","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Makanan","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Makanan","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Makanan","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Makanan","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Makanan","Batak Angkola"));
		}
		return "NonUserJenisMakanan";		
	}

	@RequestMapping ("/NonUserJenisPakaianAdat/{jenis}")
	public String jenisPakaianAdatNonUser(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Angkola"));
		}
		return "NonUserJenisPakaianAdat";		
	}

	@RequestMapping ("/NonUserJenisRumahAdat/{jenis}")
	public String jenisRumahAdatNonUser(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", bService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Angkola"));
		}
		return "NonUserJenisRumahAdat";		
	}	

	
	
	
	@RequestMapping("/formLogin")
	public String formLogin(HttpServletRequest request) {
		if(Boolean.parseBoolean(""+request.getSession().getAttribute("NonUser")) == true){
			return "redirect:/";
		}
		else if(Boolean.parseBoolean(""+request.getSession().getAttribute("Vendor")) == true){
			return "redirect:/HomeVendor";
		}
		else if(Boolean.parseBoolean(""+request.getSession().getAttribute("Pariwisata")) == true){
			return "redirect:/HomePariwisata";
		}
		return "FormLogin";
	}
}
