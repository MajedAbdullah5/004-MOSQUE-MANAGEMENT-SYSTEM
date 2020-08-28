package com.Alipur.MosqueManagement.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Alipur.MosqueManagement.entity.Mosque;

public interface MosqueRepository extends JpaRepository<Mosque, Integer> {
	@Query("SELECT m FROM Mosque m where "
			+"CONCAT(m.name,m.address,m.trade_head,m.credit_amount,m.debit_amount,m.wop,m.yot)"
			+ " LIKE %?1%")
	List<Mosque> findAll(String keyword);

	//This one you can replace, without query
	//how?
	// Organization donation
	@Query("SELECT org FROM Mosque org WHERE org.trade_head=?1 ORDER BY org.id DESC")
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
	
	/*----------------------------- Debit Lists----------------------------------- */
	// Honors
	@Query("SELECT HONORS FROM Mosque HONORS WHERE HONORS.trade_head='HONORS' ORDER BY HONORS.id DESC")
		List<Mosque> honor();
	@Query("SELECT mobile FROM Mosque mobile WHERE mobile.trade_head='MOBILE BILL' ORDER BY mobile.id DESC")
	List<Mosque> mobileBill();
	@Query("SELECT travel FROM Mosque travel WHERE travel.trade_head='TRAVEL COSTS' ORDER BY travel.id DESC")
	List<Mosque> travel();
	@Query("SELECT general FROM Mosque general WHERE general.trade_head='GENERAL WAGE' ORDER BY general.id DESC")
	List<Mosque> generalWage();
	@Query("SELECT loan FROM Mosque loan WHERE loan.trade_head='LOAN PAYMENT' ORDER BY loan.id DESC")
	List<Mosque> loanPayment();	
	@Query("SELECT electricity  FROM Mosque electricity  WHERE electricity .trade_head='ELECTRICITY BILL' ORDER BY electricity .id DESC")
	List<Mosque> electricityBill();
	@Query("SELECT fuel FROM Mosque fuel WHERE fuel.trade_head='FUEL CONSUMPTION' ORDER BY fuel.id DESC")
	List<Mosque> fuel();
	@Query("SELECT constructor FROM Mosque constructor WHERE constructor.trade_head='CONSTRUCTOR WAGE' ORDER BY constructor.id DESC")
	List<Mosque> constructorWage();
	@Query("SELECT paint FROM Mosque paint WHERE paint.trade_head='PAINT CONSUMPTION' ORDER BY paint.id DESC")
	List<Mosque> paint();
	@Query("SELECT electric FROM Mosque electric WHERE electric.trade_head='ELECTRIC EQUIPMENT' ORDER BY electric.id DESC")
	List<Mosque> electricEquipment();
	
	@Query("SELECT meterials FROM Mosque meterials WHERE meterials.trade_head='PURCHASE METERIALS' ORDER BY meterials.id DESC")
	List<Mosque> meterials();
	@Query("SELECT miscillaneous FROM Mosque miscillaneous WHERE miscillaneous.trade_head='MISCILLANEOUS COSTS' ORDER BY miscillaneous.id DESC")
	List<Mosque> miscillaneous();
	@Query("SELECT repair FROM Mosque repair WHERE repair.trade_head='REPAIR & MAINTENANCE' ORDER BY repair.id DESC")
	List<Mosque> repair();
	@Query("SELECT furniture FROM Mosque furniture WHERE furniture.trade_head='PURCHASE OF FURNITURE' ORDER BY furniture.id DESC")
	List<Mosque> furniture();
	@Query("SELECT entertainment FROM Mosque entertainment WHERE entertainment.trade_head='ENTERTAINMENT CONSUMPTION' ORDER BY entertainment.id DESC")
	List<Mosque> entertainment();
	@Query("SELECT transportation FROM Mosque transportation WHERE transportation.trade_head='TRANSPORTATION CONSUMPTION' ORDER BY transportation.id DESC")
	List<Mosque> transportation();


}
