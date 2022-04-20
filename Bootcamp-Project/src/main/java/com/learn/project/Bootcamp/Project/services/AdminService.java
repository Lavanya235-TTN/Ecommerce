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

/*
 * SELLER SERVICE
 * 
 * Boolean sellerExist(String email){
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    public List<Object []> getMyData(String email){
        if (sellerExist(email)){
            List<Object[]> partialData = sellerRepository.findDataById(email);
            return partialData;
        }
        else {
            throw new UserNotFoundException("Seller not found");
        }
    }

    public void updateProfile(String email, SellerDto sellerDto){
        if (sellerExist(email)){
            User user=userRepository.findByEmail(email);
            user.setFirstName(sellerDto.getFirstName());
            user.setLastName(sellerDto.getLastName());
            Long id = user.getId();
            Seller seller = sellerRepository.findSellerById(id);
            seller.setCompanyContact(sellerDto.getCompanyContact());
            seller.setCompanyName(seller.getCompanyName());
            userRepository.save(user);
            sellerRepository.save(seller);
        }
        else {
            throw new UserNotFoundException("Seller not found");
        }
    }

    public void updateMyPassword(String email, SellerDto sellerDto){
        if (sellerExist(email)){
            User user=userRepository.findByEmail(email);
            user.setPassword(passwordEncoder.encode(sellerDto.getPassword()));
            userRepository.save(user);
        }
        else {
            throw new UserNotFoundException("Seller not found");
        }
    }

    public void updateAddress(String email, AddressDto addressDto, Long id){
        if (sellerExist(email)){
            User user=userRepository.findByEmail(email);
            Address address = addressRepository.getByIdAndUser(id, user);
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setCountry(addressDto.getCountry());
            address.setAddressLine(addressDto.getAddressLine());
            address.setZipCode(addressDto.getZipCode());
            address.setLabel(addressDto.getLabel());
            addressRepository.save(address);
        }
        else {
            throw new UserNotFoundException("Address not found");
        }
    }
    
    CUSTOMER
    
    Boolean customerExist(String email){
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    public List<Object []> getMyData(String email){
        if (customerExist(email)){
            List<Object[]> partialData = customerRepository.findDataById(email);
            return partialData;
        }
        else {
            throw new UserNotFoundException("Customer not found");
        }
    }

    public List<Object []> getAddress(String email){
        if (customerExist(email)){
            List<Object[]> partialData = customerRepository.findAddress(email);
            return partialData;
        }
        else {
            throw new UserNotFoundException("Customer not found");
        }
    }


    public void updateProfile(String email, CustomerDto customerDto){
        if (customerExist(email)){
            User user=userRepository.findByEmail(email);
            user.setFirstName(customerDto.getFirstName());
            user.setLastName(customerDto.getLastName());
            Long id = user.getId();
            Customer customer = customerRepository.findCustomerById(id);
            customer.setContact(customerDto.getContact());
            userRepository.save(user);
            customerRepository.save(customer);
        }
        else {
            throw new UserNotFoundException("Customer not found");
        }
    }

    public void updateMyPassword(String email, CustomerDto customerDto){
        if (customerExist(email)){
            User user=userRepository.findByEmail(email);
            user.setPassword(passwordEncoder.encode(customerDto.getPassword()));
            userRepository.save(user);
        }
        else {
            throw new UserNotFoundException("Customer not found");
        }
    }

    public void addAddress(String email, AddressDto addressDto){
        if (customerExist(email)){
            User user=userRepository.findByEmail(email);
            Address address = new Address();
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setCountry(addressDto.getCountry());
            address.setAddressLine(addressDto.getAddressLine());
            address.setZipCode(addressDto.getZipCode());
            address.setLabel(addressDto.getLabel());
            address.setUser(user);
            addressRepository.save(address);
        }
        else {
            throw new UserNotFoundException("Customer not found");
        }
    }

    public void deleteAddress(String email, Long id){
        if (customerExist(email)){
            User user=userRepository.findByEmail(email);
            addressRepository.delete(addressRepository.getByIdAndUser(id, user));
        }
        else {
            throw new UserNotFoundException("Address not found");
        }
    }

    public void updateAddress(String email, AddressDto addressDto, Long id){
        if (customerExist(email)){
            User user=userRepository.findByEmail(email);
            Address address = addressRepository.getByIdAndUser(id, user);
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setCountry(addressDto.getCountry());
            address.setAddressLine(addressDto.getAddressLine());
            address.setZipCode(addressDto.getZipCode());
            address.setLabel(addressDto.getLabel());
            addressRepository.save(address);
        }
        else {
            throw new UserNotFoundException("Address not found");
        }
    }
 * */
