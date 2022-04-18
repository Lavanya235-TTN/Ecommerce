package com.learn.project.Bootcamp.Project.controller.userController;

import com.learn.project.Bootcamp.Project.dto.CustomerDto;
import com.learn.project.Bootcamp.Project.dto.SellerDto;
import com.learn.project.Bootcamp.Project.dto.UserDto;
import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.Seller;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.model.token.ConfirmationToken;
import com.learn.project.Bootcamp.Project.repository.RoleRepository;
import com.learn.project.Bootcamp.Project.repository.SellerRepository;
import com.learn.project.Bootcamp.Project.repository.TokenRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import com.learn.project.Bootcamp.Project.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @PostMapping(value = {"/register"})
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto userDto) {
        //Convert DTO to entity
        Customer userRequest = modelMapper.map(userDto, Customer.class);

        //create user
        Customer user = userService.createCustomer(userRequest);

        //Convert entity to DTO
        CustomerDto userResponse = modelMapper.map(user, CustomerDto.class);

        if (userResponse == null) {
            return new ResponseEntity<CustomerDto>(userResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CustomerDto>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping(value = {"seller/register"})
    public ResponseEntity<SellerDto> createSeller(@Valid @RequestBody SellerDto userDto) {
        //Convert DTO to entity
        Seller userRequest = modelMapper.map(userDto, Seller.class);

        //create user
        Seller user = userService.createSeller(userRequest);

        //Convert entity to DTO
        SellerDto userResponse = modelMapper.map(user, SellerDto.class);

        if (userResponse == null) {
            return new ResponseEntity<SellerDto>(userResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SellerDto>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/confirm-account")
    public void confirmAcount(@RequestParam("token") String confirmationToken) {
        ConfirmationToken token = tokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByEmail(token.getUserEntity().getEmail());
            user.setActive(true);
            userRepository.save(user);
        } else {
            System.out.println("token invalid");
        }

    }
}
