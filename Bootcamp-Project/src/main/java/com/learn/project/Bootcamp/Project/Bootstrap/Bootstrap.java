package com.learn.project.Bootcamp.Project.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.learn.project.Bootcamp.Project.dto.UserDto;
import com.learn.project.Bootcamp.Project.enums.ERole;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import com.learn.project.Bootcamp.Project.services.RoleService;
import com.learn.project.Bootcamp.Project.services.UserService;

import java.util.HashSet;
import java.util.Set;

//import static com.example.bootcamp.project.constants.AppConstants.*;

@Component
public class Bootstrap implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;



    @Override
    public void run(ApplicationArguments args) throws Exception {
    	roleService.saveRole(ERole.ROLE_ADMIN);
        roleService.saveRole(ERole.ROLE_SELLER);
        roleService.saveRole(ERole.ROLE_CUSTOMER);
        String admin_email = "admin@gmail.com";
        if(userRepository.findByEmail(admin_email) == null) {
        	UserDto userDto = new UserDto();
            userService.createAdmin(new UserDto(admin_email, "Admin", "Admin", "Admin", "aDminn@123"));
        }

    }
}