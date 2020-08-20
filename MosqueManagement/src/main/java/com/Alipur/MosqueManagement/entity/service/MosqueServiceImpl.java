package com.Alipur.MosqueManagement.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public List<Mosque> findPerson(String value) {
		if (value != null) {
			return theMosqueRepositoy.findPerson(value.toLowerCase());
		} else {
			throw new RuntimeException("USER NOT AVAILABE " + value);
		}

	}

	@Override
	public Page<Mosque> findAllByPage(int pageNumber) {
		Sort sort = Sort.by("id").descending();
		Pageable pageable = PageRequest.of(pageNumber - 1, 10,sort);
		return theMosqueRepositoy.findAll(pageable);
	}

	@Override
	public List<Mosque> bankWithdrawn(String value) {		
		return theMosqueRepositoy.bankWithdrawn(value);
	}

	@Override
	public List<Mosque> findAll() {	
		return theMosqueRepositoy.findAll();
	}

	


}
