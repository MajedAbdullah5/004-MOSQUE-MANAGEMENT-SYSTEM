package com.Alipur.MosqueManagement.entity.service;

import java.util.List;

import com.Alipur.MosqueManagement.entity.Mosque;

public interface MosqueService {
	
//	public List<Mosque> listAll(String keyword);
	
	public List<Mosque> listAllForAdmin(String param);

	public Mosque findById(int theId);

	public void save(Mosque theMosque);
	
//	public void saveDebit(Mosque theMosque);

	public void deleteByid(int theId);

	public List<Mosque> orgDonation(String value);

	public List<Mosque> personDonation(String value);

	public List<Mosque> landSale(String value);

	public List<Mosque> unnecessaryEquipmentSale(String value);

	public List<Mosque> collectionJummah(String value);

	public List<Mosque> specialFitrCollection(String value);

	public List<Mosque> specialAdhaCollection(String value);

	public List<Mosque> specialJummahCollection(String value);

	public List<Mosque> tarawihExtra(String value);

	public List<Mosque> socialCollection(String value);

	public List<Mosque> bankWithdrawn(String value);

	public List<Mosque> otherCollection(String value);
	

	/* ----------------------------Debit Lists----------------------*/
	public List<Mosque> honors();
	public List<Mosque> mobileBill();
	public List<Mosque> travel();
	public List<Mosque> generalWage();
	public List<Mosque> loanPayment();
	public List<Mosque> ElectricityBill();
	public List<Mosque> fuel();
	public List<Mosque> constructor();
	public List<Mosque> paint();
	public List<Mosque> electric();
	public List<Mosque> meterial();
	public List<Mosque> miscillaneous();
	public List<Mosque> repair();
	public List<Mosque> furniture();
	public List<Mosque> entertainment();
	public List<Mosque> transportation();
}
