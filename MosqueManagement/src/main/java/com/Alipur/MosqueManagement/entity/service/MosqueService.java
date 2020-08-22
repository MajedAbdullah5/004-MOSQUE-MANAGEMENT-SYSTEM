package com.Alipur.MosqueManagement.entity.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Alipur.MosqueManagement.entity.Mosque;

public interface MosqueService {
	public double totalBalance();
	
	public List<Mosque> listAll(String keyword);
	
	public List<Mosque> listAllForAdmin(String param);

	public Mosque findById(int theId);

	public void save(Mosque theMosque);

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

}
