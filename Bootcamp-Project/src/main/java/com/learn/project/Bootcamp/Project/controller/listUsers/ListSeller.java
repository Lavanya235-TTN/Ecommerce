package com.learn.project.Bootcamp.Project.controller.listUsers;

import java.util.List;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.project.Bootcamp.Project.repository.SellerRepository;
import com.learn.project.Bootcamp.Project.services.AdminService;

@Where(clause = "is_active=true")
@RestController
public class ListSeller {
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
    AdminService adminService;
	
	@GetMapping("/viewSellers")
    public List<Object[]> getSellers(){
        return sellerRepository.findAllSeller();
    }

}
