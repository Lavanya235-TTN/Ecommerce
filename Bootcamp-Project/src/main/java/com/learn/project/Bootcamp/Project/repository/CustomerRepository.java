package com.learn.project.Bootcamp.Project.repository;

import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.Seller;
import com.learn.project.Bootcamp.Project.model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select id,concat(firstName,' ',COALESCE(middleName,''),' ',lastName) as FullName,email,isActive from Customer")// where isActive=true")
    List<Object[]> findAllCustomer();


    List<Customer> findAll();
}
 //Firstname + ' ' + ISNULL(MiddleName,'') + ' '  + LastName AS FullName