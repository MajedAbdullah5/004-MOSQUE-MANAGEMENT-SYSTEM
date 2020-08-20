//package com.Alipur.MosqueManagement.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.Alipur.MosqueManagement.entity.Mosque;
//import com.Alipur.MosqueManagement.entity.service.MosqueService;
//
//@Controller
//@RequestMapping("/user")
//public class UserPanel {
//	
//	private MosqueService theMosqueService;
//
//	@Autowired
//	public UserPanel(MosqueService theMosqueService) {
//		this.theMosqueService = theMosqueService;
//	}
//	
//	
//	// Home page
//	@GetMapping("/")
//	public String getHome() {
//		return "A-home-page";
//	}
//
//	
//	@GetMapping("/combine-report")
//	public String getCombineReport(Model theModel) {
//		List<Mosque> theMosque = theMosqueService.findAll();		
//		theModel.addAttribute("listforuser", theMosque);
//		return "S-list-for-users";
//	}
//
//}
