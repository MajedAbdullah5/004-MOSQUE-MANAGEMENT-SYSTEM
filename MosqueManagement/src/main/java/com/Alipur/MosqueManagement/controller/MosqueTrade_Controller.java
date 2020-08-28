package com.Alipur.MosqueManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//---------------------------------debit
	@Value("${HONORS}")
	private String HONORS;
	@Value("${MOBILE.BILL}")
	private String MOBILE_BILL ;
	@Value("${TRAVEL.COSTS}")
	private String TRAVEL_COSTS;
	@Value("${GENERAL.WAGE}")
	private String GENERAL_WAGE;
	@Value("${LOAN.PAYMENT}")
	private String LOAN_PAYMENT ;
	@Value("${ELECTRICITY.BILL}")
	private String ELECTRICITY_BILL ;
	@Value("${FUEL.CONSUMPTION}")
	private String FUEL_CONSUMPTION;
	@Value("${CONSTRUCTOR.WAGE}")
	private String CONSTRUCTOR_WAGE;
	@Value("${PAINT.CONSUMPTION}")
	private String PAINT_CONSUMPTION;
	@Value("${ELECTRIC.EQUIPMENT}")
	private String ELECTRIC_EQUIPMENT;
	@Value("${PURCHASE.METERIALS}")
	private String PURCHASE_METERIALS;
	@Value("${MISCILLANEOUS.COSTS}")
	private String MISCILLANEOUS_COSTS;
	@Value("${REPAIR.&.MAINTENANCE}")
	private String REPAIR_and_MAINTENANCE;
	@Value("${PURCHASE.OF.FURNITURE}")
	private String PURCHASE_OF_FURNITURE;
	@Value("${ENTERTAINMENT.CONSUMPTION}")
	private String ENTERTAINMENT_CONSUMPTION;
	@Value("${TRANSPORTATION.CONSUMPTION}")
	private String TRANSPORTATION_CONSUMPTION;

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

	// login form
	@GetMapping("/login")
	public String getLoginForm() {
		return "U-custom-login-form";
	}
	// Report form
	@GetMapping("/combineReport")
	public String getReport(Model theModel, @Param("keyword") String keyword) {
		List<Mosque> theMosque = theMosqueService.listAllForAdmin(keyword);
		theModel.addAttribute("listforuser", theMosque);
		return "Y-report";
	}

	// Find all feature and search
	@GetMapping("/combine-report")
	public String getCombineReport(Model theModel, @Param("keyword") String keyword) {
		List<Mosque> theMosque = theMosqueService.listAllForAdmin(keyword);
		theModel.addAttribute("listforuser", theMosque);
		return "SS-list-for-users";
	}

	// Access Denied
	@GetMapping("/403")
	public String accessDenied() {
		return "V-access-denied";
	}

	// Find all feature and search for admin
	@GetMapping("/list")
	public String getCombineReportForAdmin(Model theModel, @Param("param") String param) {
		List<Mosque> theMosque = theMosqueService.listAllForAdmin(param);
		theModel.addAttribute("listAll", theMosque);
		return "listAll";
	}

	// Contributor
	@GetMapping("/contributor")
	public String getContributor() {
		return "T-contributor";
	}

	// Add Credit
	@GetMapping("/addCredit")
	public String addCredit(Model theModel) {
		Mosque theMosque = new Mosque();
		theModel.addAttribute("theMosque", theMosque);
		return "C-add-credit";
	}

	// Add Debit
	@GetMapping("/addDebit")
	public String addDebit(Model theModel) {
		Mosque theMosque = new Mosque();
		theModel.addAttribute("theMosque", theMosque);
		return "CC-add-debit";
	}

	// save credit Account
	@PostMapping("/save")
	public String save(@ModelAttribute("saveAttribute") Mosque theMosque) {
		theMosqueService.save(theMosque);
		return "redirect:/mosque/list";

	}
//	// save debit Account
//	@PostMapping("/saveDebit")
//	public String saveDebit(@ModelAttribute("saveAttribute") @Valid  Mosque theMosque2,BindingResult theBindingResult) {
//		if(theBindingResult.hasErrors()) {
//			return "C-add-debit";
//		}
//		theMosqueService.saveDebit(theMosque2);		
//		return "redirect:/mosque/list";
//	}

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

	// bank withdrawn
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
	//About us
	@GetMapping("/about")
	public String about() {
		return "W-about-mosque";
	}
	//Contact us
	@GetMapping("/contact")
	public String contact() {
		return "X-contact";
	}
	
//	----------------------------Debit lists
	
	// honor
	@GetMapping("/honor")
	public String honor(Model theModel) {
		List<Mosque> theMosque = theMosqueService.honors();
		theModel.addAttribute("honor", theMosque);
		return "DA-honor";
	}
	
	// honor
	@GetMapping("/mobileBill")
	public String mobileBill(Model theModel) {
		List<Mosque> theMosque = theMosqueService.mobileBill();
		theModel.addAttribute("mobileBill", theMosque);
		return "DB-mobileBill";
	}
	
	// honor
	@GetMapping("/travelCost")
	public String travelCost(Model theModel) {
		List<Mosque> theMosque = theMosqueService.travel();
		theModel.addAttribute("travelCost", theMosque);
		return "DC-travelCost";
	}
	
	// honor
	@GetMapping("/generalWage")
	public String generalWage(Model theModel) {
		List<Mosque> theMosque = theMosqueService.generalWage();
		theModel.addAttribute("generalWage", theMosque);
		return "DD-generalWage";
	}
	
	// honor
	@GetMapping("/loanPayment")
	public String loanPayment(Model theModel) {
		List<Mosque> theMosque = theMosqueService.loanPayment();
		theModel.addAttribute("loanPayment", theMosque);
		return "DE-loanPayment";
	}
	
	@GetMapping("/electricityBill")
	public String electricityBill(Model theModel) {
		List<Mosque> theMosque = theMosqueService.ElectricityBill();
		theModel.addAttribute("electricityBill", theMosque);
		return "DF-electricityBill";
	}
	
	// honor
	@GetMapping("/fuelConsumption")
	public String fuelConsumption(Model theModel) {
		List<Mosque> theMosque = theMosqueService.fuel();
		theModel.addAttribute("fuelConsumption", theMosque);
		return "DF-fuelConsumption";
	}
	@GetMapping("/constructorWage")
	public String constructorWage(Model theModel) {
		List<Mosque> theMosque = theMosqueService.constructor();
		theModel.addAttribute("constructorWage", theMosque);
		return "DG-constructorWage";
	}
	@GetMapping("/paintConsumption")
	public String paintConsumption(Model theModel) {
		List<Mosque> theMosque = theMosqueService.paint();
		theModel.addAttribute("paintConsumption", theMosque);
		return "DH-paintConsumption";
	}
	@GetMapping("/electricEquipment")
	public String electricEquipment(Model theModel) {
		List<Mosque> theMosque = theMosqueService.electric();
		theModel.addAttribute("electricEquipment", theMosque);
		return "DI-electricEquipment";
	}
	@GetMapping("/purchaseMeterials")
	public String purchaseMeterials(Model theModel) {
		List<Mosque> theMosque = theMosqueService.meterial();
		theModel.addAttribute("purchaseMeterials", theMosque);
		return "DJ-purchaseMeterials";
	}
	@GetMapping("/miscillaneousCosts")
	public String miscillaneousCosts(Model theModel) {
		List<Mosque> theMosque = theMosqueService.miscillaneous();
		theModel.addAttribute("miscillaneousCosts", theMosque);
		return "DK-miscillaneousCosts";
	}
	@GetMapping("/repair")
	public String repair(Model theModel) {
		List<Mosque> theMosque = theMosqueService.repair();
		theModel.addAttribute("repair", theMosque);
		return "DL-repair";
	}
	@GetMapping("/furniture")
	public String furniture(Model theModel) {
		List<Mosque> theMosque = theMosqueService.furniture();
		theModel.addAttribute("furniture", theMosque);
		return "DM-furniture";
	}
	@GetMapping("/entertainmentCons")
	public String entertainmentCons(Model theModel) {
		List<Mosque> theMosque = theMosqueService.entertainment();
		theModel.addAttribute("entertainmentCons", theMosque);
		return "DN-entertainmentCons";
	}
	@GetMapping("/transportation")
	public String transportation(Model theModel) {
		List<Mosque> theMosque = theMosqueService.transportation();
		theModel.addAttribute("transportation", theMosque);
		return "DO-transportation";
	}

}
