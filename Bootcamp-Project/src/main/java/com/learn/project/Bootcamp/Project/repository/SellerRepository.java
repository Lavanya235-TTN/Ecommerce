package com.learn.project.Bootcamp.Project.repository;

import com.learn.project.Bootcamp.Project.model.Users.Seller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

	@Query("select id,concat(firstName,' ',COALESCE(middleName,''),' ',lastName) as FullName,email,isActive from Seller")// where isActive=true")
	List<Object[]> findAllSeller();
	
	List<Seller> findAll();
}
