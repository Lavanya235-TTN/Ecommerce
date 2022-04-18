package com.learn.project.Bootcamp.Project.repository;

import com.learn.project.Bootcamp.Project.model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

//    @Query("from Customer where isActive=true")
//    List<User> findAllCustomers();

}
