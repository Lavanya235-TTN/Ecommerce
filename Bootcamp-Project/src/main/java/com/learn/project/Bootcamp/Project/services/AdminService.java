package com.learn.project.Bootcamp.Project.services;

import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.repository.CustomerRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    public List<Object[]> getCustomerList(){
        List<Object[]> partialData =customerRepository.findAllCustomer();
        for (Object[] objects : partialData) {
            System.out.println("Id: "+objects[0]+" FullName: "+objects[1]+"Emial: "+objects[2]);
        }
        return partialData;



    }

    public User activateCustomer(User user) {
        user.setActive(true);
        userRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Account Activation!");
        mailMessage.setText("Congratulations!!\nYour account is being activated. We hope you enjoy our service");
        emailService.sendEmail(mailMessage);
        return user;

    }

    public User deactivateCustomer(User user) {
        user.setActive(false);
        userRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Account De-Activation!");
        mailMessage.setText("Your account is De-Activated :( \nFeel free to connect if you want to activate you account.");
        emailService.sendEmail(mailMessage);
        return user;

    }
    
    public User activateSeller(User user) {
        user.setActive(true);
        userRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Account Activation!");
        mailMessage.setText("Congratulations!!\nYour account is being activated. We hope you enjoy our service");
        emailService.sendEmail(mailMessage);
        return user;

    }

    public User deactivateSeller(User user) {
        user.setActive(false);
        userRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Account De-Activation!");
        mailMessage.setText("Your account is De-Activated :( \nFeel free to connect if you want to activate you account.");
        emailService.sendEmail(mailMessage);
        return user;

    }
}
