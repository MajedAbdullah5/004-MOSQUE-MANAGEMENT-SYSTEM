package com.Alipur.MosqueManagement.entity.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alipur.MosqueManagement.entity.Mosque;
import com.Alipur.MosqueManagement.entity.dao.MosqueRepository;

@Service
public class MosqueServiceImpl implements MosqueService {
	private MosqueRepository theMosqueRepositoy;

	@Autowired
	public MosqueServiceImpl(MosqueRepository theMosqueRepositoy) {
		this.theMosqueRepositoy = theMosqueRepositoy;
	}

	@Override
	public Mosque findById(int theId) {

		Optional<Mosque> result = theMosqueRepositoy.findById(theId);
		Mosque theMosque = null;
		if (result.isPresent()) {
			theMosque = result.get();
		} else {
			throw new RuntimeException("Invalid Id" + theId);
		}
		return theMosque;
	}

	@Override
	public void save(Mosque theMosque) {
		theMosqueRepositoy.save(theMosque);
	}
	@Override
	public void deleteByid(int theId) {
		theMosqueRepositoy.deleteById(theId);

	}

	@Override
	public List<Mosque> orgDonation(String value) {
		return theMosqueRepositoy.orgDonation(value);
	}

	@Override
	public List<Mosque> personDonation(String value) {
		return theMosqueRepositoy.personDonation(value);
	}

	@Override
	public List<Mosque> landSale(String value) {
		return theMosqueRepositoy.landSale(value);
	}

	@Override
	public List<Mosque> unnecessaryEquipmentSale(String value) {
		return theMosqueRepositoy.unnecessaryEquipmentSale(value);
	}

	@Override
	public List<Mosque> collectionJummah(String value) {
		return theMosqueRepositoy.collectionJummah(value);
	}

	@Override
	public List<Mosque> specialFitrCollection(String value) {
		return theMosqueRepositoy.specialFitrCollection(value);
	}

	@Override
	public List<Mosque> specialAdhaCollection(String value) {
		return theMosqueRepositoy.specialAdhaCollection(value);
	}

	@Override
	public List<Mosque> specialJummahCollection(String value) {
		return theMosqueRepositoy.specialJummahCollection(value);
	}

	@Override
	public List<Mosque> tarawihExtra(String value) {
		return theMosqueRepositoy.tarawihExtra(value);
	}

	@Override
	public List<Mosque> socialCollection(String value) {
		return theMosqueRepositoy.socialCollection(value);
	}

	@Override
	public List<Mosque> otherCollection(String value) {
		return theMosqueRepositoy.otherCollection(value);
	}

	@Override
	public List<Mosque> bankWithdrawn(String value) {
		return theMosqueRepositoy.bankWithdrawn(value);
	}
	@Override
	public List<Mosque> listAllForAdmin(String param) {
		List<Mosque> list = theMosqueRepositoy.findAll();
		double total = 0;
		for (Mosque mosque : list) {
			total += mosque.getCredit_amount() - mosque.getDebit_amount();
			mosque.setTotal_balance(total);
		}
//		list.forEach(System.out::println);
		list.sort(Comparator.comparing(Mosque::getId).reversed());
		if (param != null) {
			return theMosqueRepositoy.findAll(param);
		}
		return list;
	}

	@Override
	public List<Mosque> honors() {
		return theMosqueRepositoy.honor();
	}

	@Override
	public List<Mosque> mobileBill() {
		return theMosqueRepositoy.mobileBill();
	}

	@Override
	public List<Mosque> travel() {
		return theMosqueRepositoy.travel();
	}

	@Override
	public List<Mosque> generalWage() {
		return theMosqueRepositoy.generalWage();
	}

	@Override
	public List<Mosque> loanPayment() {
		return theMosqueRepositoy.loanPayment();
	}

	@Override
	public List<Mosque> ElectricityBill() {
		return theMosqueRepositoy.electricityBill();
	}

	@Override
	public List<Mosque> fuel() {
		return theMosqueRepositoy.fuel();
	}

	@Override
	public List<Mosque> constructor() {
		return theMosqueRepositoy.constructorWage();
	}

	@Override
	public List<Mosque> paint() {
		return theMosqueRepositoy.paint();
	}

	@Override
	public List<Mosque> electric() {
		return theMosqueRepositoy.electricEquipment();
	}

	@Override
	public List<Mosque> meterial() {
		return theMosqueRepositoy.meterials();
	}

	@Override
	public List<Mosque> miscillaneous() {
		return theMosqueRepositoy.miscillaneous();
	}

	@Override
	public List<Mosque> repair() {
		return theMosqueRepositoy.repair();
	}

	@Override
	public List<Mosque> furniture() {
		return theMosqueRepositoy.furniture();
	}

	@Override
	public List<Mosque> entertainment() {
		return theMosqueRepositoy.entertainment();
	}

	@Override
	public List<Mosque> transportation() {
		return theMosqueRepositoy.transportation();
	}
}
