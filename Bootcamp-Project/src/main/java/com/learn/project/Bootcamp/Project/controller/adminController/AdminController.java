package com.learn.project.Bootcamp.Project.controller.adminController;

import com.learn.project.Bootcamp.Project.dto.CustomerDto;
import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.repository.SellerRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import com.learn.project.Bootcamp.Project.services.AdminService;
import com.learn.project.Bootcamp.Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SellerRepository sellerRepository;
    
    @Autowired
    AdminService adminService;


    @PutMapping(value = "/activateCustomer/{id}")
    public ResponseEntity<User> activateCustomer(@PathVariable("id") int id){
        System.out.println("ID: "+id);
        User customer=userRepository.findById(id).get();
        if(customer==null){
            System.out.println("Not found");
            return new ResponseEntity<User>(customer, HttpStatus.NOT_FOUND);
        }
        else if(customer.isActive()){
            System.out.println("Already active customer");
            return new ResponseEntity<User>(customer, HttpStatus.BAD_REQUEST);
        }
        else {
            System.out.println("Found");

            User customer1=adminService.activateCustomer(customer);

            return new ResponseEntity<User>(customer, HttpStatus.CREATED);

        }
    }

    @PatchMapping(value = "/deactivateCustomer/{id}")
    public ResponseEntity<User> deactivateCustomer(@PathVariable("id") int id){
        System.out.println("ID: "+id);
        User customer=userRepository.findById(id).get();
        if(customer==null){
            System.out.println("Not found");
            return new ResponseEntity<User>(customer, HttpStatus.NOT_FOUND);
        }
        else if(customer.isActive()){
            User customer1=adminService.deactivateCustomer(customer);

            return new ResponseEntity<User>(customer, HttpStatus.CREATED);

        }
        else {

            System.out.println(" Your account is already de-activated");
            return new ResponseEntity<User>(customer, HttpStatus.OK);

        }
    }

    @PatchMapping(value = "/activateSeller/{id}")
    public ResponseEntity<User> activateSeller(@PathVariable("id") int id){
        System.out.println("ID: "+id);
        User seller=userRepository.findById(id).get();
        if(seller==null){
            System.out.println("Not found");
            return new ResponseEntity<User>(seller, HttpStatus.NOT_FOUND);
        }
        else if(seller.isActive()){
            System.out.println(" found");
            return new ResponseEntity<User>(seller, HttpStatus.OK);
        }
        else {
            System.out.println("ound");

            User seller1=adminService.activateSeller(seller);

            return new ResponseEntity<User>(seller, HttpStatus.CREATED);

        }
    }

    @PatchMapping(value = "/deactivateSellerr/{id}")
    public ResponseEntity<User> deactivateSeller(@PathVariable("id") int id){
        System.out.println("ID: "+id);
        User seller=userRepository.findById(id).get();
        if(seller==null){
            System.out.println("Not found");
            return new ResponseEntity<User>(seller, HttpStatus.NOT_FOUND);
        }
        else if(seller.isActive()){
            User seller1=adminService.deactivateSeller(seller);

            return new ResponseEntity<User>(seller, HttpStatus.CREATED);

        }
        else {

            System.out.println(" Your account is already de-activated");
            return new ResponseEntity<User>(seller, HttpStatus.OK);

        }
    }

    
}
