package com.Alipur.MosqueManagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Alipur.MosqueManagement.entity.Mosque;
import com.Alipur.MosqueManagement.entity.service.MosqueService;

@Controller
@RequestMapping("/mosque")
public class MosqueTrade_Controller {

	@Value("${ORG.DONATION}")
	private String org_Donation;

	@Value("${PERSON.DONATION}")
	private String person_Donation;

	@Value("${LAND.SALE}")
	private String land_Sale;

	@Value("${UNNECESSARY.EQUIPMENT.SALE}")
	private String unnecessary_Equipment_Sale;

	@Value("${COLLECTION.JUMMAH}")
	private String collection_Jummah;

	@Value("${SPECIAL.COLLECTION.(FITR)}")
	private String special_Fitr_Collection;

	@Value("${SPECIAL.COLLECTION.(ADHA)}")
	private String special_Adha_Collection;

	@Value("${SPECIAL.COLLECTION.(JUMMAH)}")
	private String special_Jummah_Collection;

	@Value("${TARAWIH.EXTRA}")
	private String tarawih_Extra;

	@Value("${SOCIAL}")
	private String social_Collection;
	
	@Value("${BANK.WITHDRAWN}")
	private String bank_withdrawn;

	@Value("${OTHER.COLLECTION}")
	private String other_Collection;

	private MosqueService theMosqueService;

	@Autowired
	public MosqueTrade_Controller(MosqueService theMosqueService) {
		this.theMosqueService = theMosqueService;
	}

	// Home page
	@GetMapping("/")
	public String getHome() {
		return "A-home-page";
	}

	// Admin panel
	@GetMapping("/admin")
	public String getLogin() {
		return "B-admin-panel";
	}
	
	@GetMapping("/combine-report")
	public String getCombineReport(Model theModel) {
		List<Mosque> theMosque = theMosqueService.findAll();		
		theModel.addAttribute("listforuser", theMosque);
		return "S-list-for-users";
	}

	// Test Pagination
	@GetMapping("/list")
	public String listAll(Model theModel) {
		return listByPage(theModel, 1);
	}
	
	// Contributor 
	@GetMapping("/contributor")
	public String getContributor(){
		return "T-contributor";
	}
	
	
	

	//Display  page pagination	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(Model theModel, @PathVariable("pageNumber") int currentPage ) {
		Page<Mosque> theMosque = theMosqueService.findAllByPage(currentPage);
		long totalItems = theMosque.getTotalElements();
		int totalPages = theMosque.getTotalPages();				
		List<Mosque> listAll = theMosque.getContent();		
		theModel.addAttribute("currentPage", currentPage);
		theModel.addAttribute("totalItems", totalItems);
		theModel.addAttribute("totalPages", totalPages);
		theModel.addAttribute("listAll", listAll);
		theModel.addAttribute("listforuser", listAll);
		return "listAll";
		
	} 
	// Add trade
	@GetMapping("/add")
	public String addTrade(Model theModel) {
		Mosque theMosque = new Mosque();
		theModel.addAttribute("theMosque", theMosque);
		return "C-add-member";
	}

	// save Account
	@PostMapping("/save")
	public String save(@ModelAttribute("saveAttribute") Mosque theMosque) {
		theMosqueService.save(theMosque);
		return "redirect:/mosque/list";
	}

	// update Account
	@GetMapping("/update")
	public String getUpdate(@RequestParam("id") int theId, Model theModel) {
		Mosque theMosque = theMosqueService.findById(theId);
		theModel.addAttribute("theMosque", theMosque);
		return "D-update-member";
	}

	// delete Account
	@GetMapping("/delete")
	public String getDelete(@RequestParam("id") int theId) {
		theMosqueService.deleteByid(theId);
		return "redirect:/mosque/list";
	}

	// Organization Donation
	@GetMapping("/orgDonation")
	public String orgDonation(Model theModel) {
		List<Mosque> list = theMosqueService.orgDonation(org_Donation);
		theModel.addAttribute("orgDonationList", list);
		return "E-org-donation";
	}

	// Person Donation
	@GetMapping("/personDonation")
	public String personDonation(Model theModel) {
		List<Mosque> personDonation = theMosqueService.personDonation(person_Donation);
		theModel.addAttribute("personDonationList", personDonation);
		return "F-person-donation";
	}

	// Land Sale
	@GetMapping("/landSale")
	public String landSale(Model theModel) {
		List<Mosque> landSale = theMosqueService.landSale(land_Sale);
		theModel.addAttribute("landSaleList", landSale);
		return "G-land-sale";

	}

	// Unnecessary Equipment Sale
	@GetMapping("/unnecessaryEquipmentSale")
	public String unnecessaryEquipmentSale(Model theModel) {
		List<Mosque> theMosque = theMosqueService.unnecessaryEquipmentSale(unnecessary_Equipment_Sale);
		theModel.addAttribute("unnecessaryEquipmentSaleList", theMosque);
		return "H-unnecessary-equipment-sale";
	}

	// Collection Jummah
	@GetMapping("/collectionJummah")
	public String collectionJummah(Model theModel) {
		List<Mosque> theMosque = theMosqueService.collectionJummah(collection_Jummah);
		theModel.addAttribute("collectionJummahList", theMosque);
		return "I-collection-jummah";

	}
	// Special Fitr Collection
	@GetMapping("/specialFitrCollection")
	public String specialFitrCollecion(Model theModel) {
		List<Mosque> theMosque = theMosqueService.specialFitrCollection(special_Fitr_Collection);
		theModel.addAttribute("specialFitrCollectionList", theMosque);
		return "J-special-fitr-collection";
	}

	// Special Adha Collection
	@GetMapping("/specialAdhaCollection")
	public String specialAdhaCollection(Model theModel) {
		List<Mosque> theMosque = theMosqueService.specialAdhaCollection(special_Adha_Collection);
		theModel.addAttribute("specialAdhaCollection", theMosque);
		return "K-special-adha-collection";
	}

	// Special Jummah Collection
	@GetMapping("/specialJummahCollection")
	public String specialJummahCollection(Model theModel) {
		List<Mosque> theMosque = theMosqueService.specialJummahCollection(special_Jummah_Collection);
		theModel.addAttribute("specialJummahCollectionList", theMosque);
		return "L-special-jummah-collection";
	}

	// Tarawih Extra
	@GetMapping("/tarawihExtra")
	public String tarawihExtra(Model theModel) {
		List<Mosque> theMosque = theMosqueService.tarawihExtra(tarawih_Extra);
		theModel.addAttribute("tarawihExtraList", theMosque);
		return "M-tarawih-extra-collection";
	}

	// Social Collection
	@GetMapping("/social")
	public String social(Model theModel) {
		List<Mosque> theMosque = theMosqueService.socialCollection(social_Collection);
		theModel.addAttribute("socialCollectionList", theMosque);
		return "N-social-collection";
	}
	
	//bank withdrawn
	@GetMapping("/bankWithdrawn")
	public String bankWithdrawn(Model theModel) {
		List<Mosque> theMosque = theMosqueService.socialCollection(bank_withdrawn);
		theModel.addAttribute("bankWithdrawn", theMosque);
		return "P-bank-withdrawn";
	}

	// Other Collection
	@GetMapping("/other")
	public String otherCollection(Model theModel) {
		List<Mosque> theMosque = theMosqueService.otherCollection(other_Collection);
		theModel.addAttribute("otherCollectionList", theMosque);
		return "O-other-collection";
	}

	// Search People
//	@GetMapping("/findPeople")
//	public String findPeople(Model theModel,@ModelAttribute("myFormObject") Mosque myFormObject ,BindingResult result) {
//		List<Mosque> products = theMosqueService.findAll(myFormObject.getName());
//		theModel.addAttribute("products",products);
//		return "listAll";
//	}

//	@GetMapping("/findPeople")
//	public String getName(@RequestParam String name, Model theModel) {
//		System.out.println("Name " + name);
//		List<Mosque> theName = theMosqueService.findPerson(name);
//		theModel.addAttribute("name",name);
//		//theModel.addAttribute("theName",theName);
//		System.out.println(theName);
//		return "listAll";
//	}

	// Cancel Payment
	@GetMapping("/cancel")
	public String cancelledPayement() {
		return "P-cancelled-payment";
	}

	// Success Payment
	@GetMapping("/success")
	public String successPayment() {
		return "R-success-payment";
	}

}
