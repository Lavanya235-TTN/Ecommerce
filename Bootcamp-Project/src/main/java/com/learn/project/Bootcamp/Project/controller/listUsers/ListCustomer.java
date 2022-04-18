package com.learn.project.Bootcamp.Project.controller.listUsers;

import com.learn.project.Bootcamp.Project.repository.CustomerRepository;
import com.learn.project.Bootcamp.Project.services.AdminService;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Where(clause = "is_active=true")
@RestController
public class ListCustomer {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AdminService adminService;

    @GetMapping("/viewCustomers")
    public List<Object[]> getCustomers(){
        System.out.println("Hello World");
        return customerRepository.findAllCustomer();
    }

//    @GetMapping("/viewCustomeers")
//    private String listProducts(Model model) {
//        model.addAttribute("customers",userRepository.findAll());
//        return "getCustomerList";
//    }






}
