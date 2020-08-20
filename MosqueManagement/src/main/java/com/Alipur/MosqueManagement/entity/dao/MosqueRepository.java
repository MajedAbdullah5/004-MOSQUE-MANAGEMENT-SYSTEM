package com.Alipur.MosqueManagement.entity.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.Alipur.MosqueManagement.entity.Mosque;

public interface MosqueRepository extends PagingAndSortingRepository<Mosque, Integer>{
	// List for users
	@Query("SELECT m FROM Mosque m ORDER BY m.id DESC")
	List<Mosque> findAll();
	
	Page<Mosque> findAll(Pageable pageable);
	// Organization Donation List
	@Query("SELECT org FROM Mosque org WHERE org.trade_head=?1")
	List<Mosque> orgDonation(String value);

	// Personal Donation List
	@Query("SELECT per FROM Mosque per WHERE per.trade_head=?1 ORDER BY per.id DESC")
	List<Mosque> personDonation(String value);

	// Land Sale
	@Query("SELECT lan FROM Mosque lan WHERE lan.trade_head=?1 ORDER BY lan.id DESC")
	List<Mosque> landSale(String value);

	// Unnecessary Equipment Sale
	@Query("SELECT equi FROM Mosque equi WHERE equi.trade_head=?1 ORDER BY equi.id DESC")
	List<Mosque> unnecessaryEquipmentSale(String value);

	// Collection Jummah
	@Query("SELECT jum FROM Mosque jum WHERE jum.trade_head=?1 ORDER BY jum.id DESC")
	List<Mosque> collectionJummah(String value);

	// Special Collection Fitr
	@Query("SELECT fitr FROM Mosque fitr WHERE fitr.trade_head=?1 ORDER BY fitr.id DESC")
	List<Mosque> specialFitrCollection(String value);

	// Special Collection Adha
	@Query("SELECT adha FROM Mosque adha WHERE adha.trade_head=?1 ORDER BY adha.id DESC")
	List<Mosque> specialAdhaCollection(String value);

	// Special Collection Jummah
	@Query("SELECT jummah FROM Mosque jummah WHERE jummah.trade_head=?1 ORDER BY jummah.id DESC")
	List<Mosque> specialJummahCollection(String value);

	// Tarawih Extra
	@Query("SELECT tarawih FROM Mosque tarawih WHERE tarawih.trade_head=?1 ORDER BY tarawih.id DESC")
	List<Mosque> tarawihExtra(String value);

	// Social
	@Query("SELECT social FROM Mosque social WHERE social.trade_head=?1 ORDER BY social.id DESC")
	List<Mosque> socialCollection(String value);
	
	// Bank Withdrawn
	@Query("SELECT bank FROM Mosque bank WHERE bank.trade_head=?1 ORDER BY bank.id DESC")
	List<Mosque> bankWithdrawn(String value);

	// Other Collection
	@Query("SELECT other FROM Mosque other WHERE other.trade_head=?1 ORDER BY other.id DESC")
	List<Mosque> otherCollection(String value);

	// Search People
	@Query("SELECT person FROM Mosque person WHERE person.name like %?1% ORDER BY person.id DESC")
	List<Mosque> findPerson(String value);
	
	
}
