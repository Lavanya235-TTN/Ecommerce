package com.learn.project.Bootcamp.Project.services;

import com.learn.project.Bootcamp.Project.dto.UserDto;
import com.learn.project.Bootcamp.Project.enums.ERole;
import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.Seller;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.model.token.ConfirmationToken;
import com.learn.project.Bootcamp.Project.repository.RoleRepository;
import com.learn.project.Bootcamp.Project.repository.TokenRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailService emailService;
    
    

    public User createAdmin(UserDto user){
    	User userRequest = modelMapper.map(user, User.class);
    	
            userRequest.addRole(roleRepository.findByName(ERole.ROLE_ADMIN.toString()));
            userRequest.setPassword(encoder.encode(userRequest.getPassword()));
            userRepository.save(userRequest);
            return userRequest;

    }
    
    public Customer createCustomer(Customer user){
        boolean ifExist=userExist(user.getEmail());
        if(ifExist){
            return null;
        }
            user.addRole(roleRepository.findByName(ERole.ROLE_CUSTOMER.toString()));
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            tokenRepository.save(confirmationToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());


            emailService.sendEmail(mailMessage);
            return user;

    }

    public Seller createSeller(Seller user){
        System.out.println(user.getEmail());
        boolean ifExist=userExist(user.getEmail());
        if(ifExist){
            System.out.println("exist");
            return null;
        }
        else{
            System.out.println("not ");
            user.addRole(roleRepository.findByName(ERole.ROLE_SELLER.toString()));
            return userRepository.save(user);
        }

    }

    Boolean userExist(String email){
        return userRepository.findByEmail(email) !=null ? true : false;
    }


    public User forgotPassword(String email) {
        System.out.println(email);
        boolean ifExist=userExist(email);
        if(ifExist){
            User user=userRepository.findByEmail(email);
            System.out.println(user.getFirstName());
            System.out.println(user.getEmail());
            System.out.println(user.getRoles());
            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            tokenRepository.save(confirmationToken);
            user.setResetPasswordToken(confirmationToken.getConfirmationToken());
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Forgot Password!");
            mailMessage.setText("To reset your password, please click here : "
                    +"http://localhost:8080/reset-password?token="+confirmationToken.getConfirmationToken());


            emailService.sendEmail(mailMessage);
            return user;
        }
        else{
            System.out.println("User is null");
            return null;

        }


    }


}
