package com.psi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.psi.models.User;
import com.psi.services.ArtikelService;
import com.psi.services.UserService;
import com.psi.models.Artikel;

@Controller
public class HomePariwisataController {

	@Autowired
	private ArtikelService artikelService;
	@Autowired
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ArtikelService getArtikelService() {
		return artikelService;
	}

	@Autowired
	public void setArtikelService(ArtikelService artikelService) {
		this.artikelService = artikelService;
	}

	@RequestMapping(value = {"/artikell/{id}"}, method = RequestMethod.GET)
    public String artikel(Model model,Principal p, @PathVariable int id){    	    	
		model.addAttribute("artikel", artikelService.find(id));
    	return "MorePariwisata";
    }
	
	
	@RequestMapping ("/PariwisataJenisTarian/{jenis}")
	public String jenisTarianPariwisata(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Tarian","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Tarian","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Tarian","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Tarian","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Tarian","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Tarian","Batak Angkola"));
		}
		return "PariwisataJenisTarian";		
	}
	@RequestMapping ("/PariwisataJenisMusik/{jenis}")
	public String jenisMusikPariwisata(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Musik","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Musik","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Musik","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Musik","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Musik","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Musik","Batak Angkola"));
		}
		return "PariwisataJenisMusik";		
	}

	@RequestMapping ("/PariwisataJenisLainya/{jenis}")
	public String jenisLainya(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Lainya","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Lainya","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Lainya","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Lainya","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Lainya","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Lainya","Batak Angkola"));
		}
		return "PariwisataJenisLainya";		
	}

	@RequestMapping ("/PariwisataJenisBendaBersejarah/{jenis}")
	public String jenisBendaBersejarahPariwisata(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Benda Bersejarah","Batak Angkola"));
		}
		return "PariwisataJenisBendaBersejarah";		
	}

	@RequestMapping ("/PariwisataJenisMakanan/{jenis}")
	public String jenisJenisMakananPariwisata(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Makanan","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Makanan","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Makanan","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Makanan","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Makanan","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Makanan","Batak Angkola"));
		}
		return "PariwisataJenisMakanan";		
	}

	@RequestMapping ("/PariwisataJenisPakaianAdat/{jenis}")
	public String jenisPakaianAdatPariwisata(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Pakaian Adat","Batak Angkola"));
		}
		return "PariwisataJenisPakaianAdat";		
	}

	@RequestMapping ("/PariwisataJenisRumahAdat/{jenis}")
	public String jenisRumahAdatPariwisata(Model model, @PathVariable String jenis)
	{
		if(jenis.equals("toba")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Toba"));
		}
		else if(jenis.equals("simalungun")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Simalungun"));
		}
		else if(jenis.equals("karo")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Karo"));
		}
		else if(jenis.equals("mandailing")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Mandailing"));
		}
		else if(jenis.equals("pakpak")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Pakpak"));
		}
		else if(jenis.equals("angkola")){
			model.addAttribute("allArtikel", artikelService.getAllArtikelByJenisArtikel("Rumah Adat","Batak Angkola"));
		}
		return "PariwisataJenisRumahAdat";		
	}	

	
	
	
	
	// Tambah

	@RequestMapping(value = "addArtikels", method = RequestMethod.GET)
	public String addArtikel(Model model, HttpServletRequest request) {
		if(Boolean.parseBoolean(""+request.getSession().getAttribute("User")) == true){
			return "redirect:/";
		}
		else if(Boolean.parseBoolean(""+request.getSession().getAttribute("Vendor")) == true){
			return "redirect:/HomeVendor";
		}
		
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/HomePariwisata";
		}
		model.addAttribute("infomasi", new Artikel());
		return "TambahInfoParis";
	}

	@RequestMapping(value = "/TambahArtikels", method = RequestMethod.POST)
	public String tambahArtikel(Artikel artikel, Model model, @RequestParam("gambars") MultipartFile file) {
		
		artikel.setGambar(file.getOriginalFilename());
		if (!file.isEmpty()) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(
						"C:/Users/erwin/Desktop/New folder/Fix/kotak/src/main/resources/static/image/"
								+ name)));
				stream.write(bytes);
				stream.close();
				System.out.println(stream);
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "The selected file was empty and could not be uploaded.";
		}
		artikel.setStatus("Confirm");
		artikelService.saveOrUpdateArtikel(artikel);
		return "redirect:/HomePariwisata";

	}
	
	
	@RequestMapping ("/InformasiMasukPariwisata")
	public String artikelMasuk(Model model, HttpServletRequest request)
	{
		if(Boolean.parseBoolean(""+request.getSession().getAttribute("User")) == true){
			return "redirect:/";
		}
		else if(Boolean.parseBoolean(""+request.getSession().getAttribute("Vendor")) == true){
			return "redirect:/HomeVendor";
		}
		
		model.addAttribute("allArtikel", artikelService.getAllTambahArtikelByStatus("NOTCONFIRM"));
		model.addAttribute("allArtikel", artikelService.getAllArtikel());
		return "InformasiMasukPariwisata";
	}
	@RequestMapping ("/approveRequests/{id}")
	public String approveRequest(@PathVariable Integer id,  Model model)
	{
		Artikel artikel = artikelService.getArtikelById(id);
		artikel.setStatus("Confirm");
		artikelService.saveOrUpdateArtikel(artikel);
		return "redirect:/InformasiMasukPariwisata";
	}
	@RequestMapping ("/rejectRequests/{id}")
	public String rejectRequest(@PathVariable Integer id,  Model model)
	{
		Artikel artikel = artikelService.getArtikelById(id);
		artikel.setStatus("NotConfirm");
		artikelService.saveOrUpdateArtikel(artikel);
		return "redirect:/InformasiMasukPariswisata";
	}	
	
	
	
	
/*
	@RequestMapping(value = "/allPemesanans")
	public String allPemesana(Model model, Model model1, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		model.addAttribute("allPemesanan", pService.getAllPemesanan() );
		return "InfoMasukParis";
	}
	
	@RequestMapping(value = "/confirms/{id}")
	public String confirm(@PathVariable Integer id, Model model, Model model1, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		Info info = infoService.getInfoById(id);
		
		Pemesanan pemesanan = pService.getPemesananById(id);
		pemesanan.setStatus("Confirmed");
	
		pService.savePemesanan(pemesanan);
		
		return "redirect:/allPemesanan";
	}
	
	@RequestMapping(value = "/rejects/{id}")
	public String reject(@PathVariable Integer id, Model model, Model model1, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		Info info = infoService.getInfoById(id);
		
		Pemesanan pemesanan = pService.getPemesananById(id);
		pemesanan.setStatus("Reject");
	
		pService.savePemesanan(pemesanan);
		
		return "redirect:/allPemesanan";
	}
	*/
	// edit
	@RequestMapping(value = "/editArtikels/{id}", method = RequestMethod.GET)
	public String editArtikel(@PathVariable Integer id, Model model, Model model1, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/HomePariwisata";
		}
		Artikel artikel = artikelService.getArtikelById(id);
		model.addAttribute("artikel", artikel);
	
		
		return "EditInfoPariwisata";
	}

	@RequestMapping(value = "/editArtikels", method = RequestMethod.POST)
	public String updateDataArtikel(Model model, Artikel artikel, @RequestParam("gambars") MultipartFile file, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/HomePariwisata";
		}
		artikel.setGambar(file.getOriginalFilename());
		if (!file.isEmpty()) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(
						"C:/Users/erwin/Desktop/New folder/Fix/kotak/src/main/resources/static/image/"
								+ name)));
				stream.write(bytes);
				stream.close();
				System.out.println(stream);
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "The selected file was empty and could not be uploaded.";
		}

		artikel = artikelService.saveOrUpdateArtikel(artikel);
		return "redirect:/HomePariwisata";
	}

	@RequestMapping(value = "/editProfils/{id}", method = RequestMethod.GET)
	public String editProfile(@PathVariable Integer id, Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "EditProfil";
	}

	@RequestMapping(value = "editProfils", method = RequestMethod.POST)
	public String updateDataUser(Model model, User user) {
		user = userService.saveOrUpdateUser(user);
		return "redirect:/HomePariwisata";

	}
	
	@RequestMapping(value = "/editProfilUsers/{id}", method = RequestMethod.GET)
	public String editProfileUser(@PathVariable Integer id, Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "ProfileUser";
	}

	@RequestMapping(value = "editProfilUsers", method = RequestMethod.POST)
	public String updateDataUsers(Model model, User user) {
		user = userService.saveOrUpdateUser(user);
		return "redirect:/";

	}
	
	@RequestMapping(value = "/deleteArtikels/{id}")
	public String deleteArtikel(@PathVariable Integer id, Model model) {
		artikelService.deleteArtikel(id);
		return "redirect:/HomePariwisata";

	}
	

	@RequestMapping("/HomePariwisata")
	public String homePariwisata(Model model, HttpServletRequest request) {
		if(Boolean.parseBoolean(""+request.getSession().getAttribute("User")) == true){
			return "redirect:/";
		}
		else if(Boolean.parseBoolean(""+request.getSession().getAttribute("Vendor")) == true){
			return "redirect:/HomeVendor";
		}
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/";
		}
		model.addAttribute("username", (Integer) request.getSession().getAttribute("pariwisata"));
		model.addAttribute("allArtikel", artikelService.getAllArtikelConfirm());
		return "HomePariwisata";
	}

}
