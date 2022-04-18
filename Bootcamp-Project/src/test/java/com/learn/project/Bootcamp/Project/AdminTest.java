package com.learn.project.Bootcamp.Project;

import com.learn.project.Bootcamp.Project.enums.ERole;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.repository.RoleRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class AdminTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    public void createAdmin(){

        User user=new User();
        user.setFirstName("Maria");
        user.setMiddleName("SS");
        user.setLastName("Rawat");
        user.setPassword(passwordEncoder.encode("maria10"));
        user.setActive(true);
        user.setExpired(false);
        user.setDeleted(Boolean.FALSE);
        user.setLocked(true);
        user.setInvalidAttempCount(0);
        user.setPasswordUpdateDate("today");
        user.addRole(roleRepository.findByName(ERole.ROLE_ADMIN.toString()));
        userRepository.save(user);

    }
//    @Test
//    public void createAD(){
//        User user=userRepository.findById(12).get();
//        user.setEmail("maria@gmail.com");
//        user.setLocked(false);
//        userRepository.save(user);
//    }


}
