package com.learn.project.Bootcamp.Project.controller.userController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.learn.project.Bootcamp.Project.dto.CustomerDto;
import com.learn.project.Bootcamp.Project.dto.UserDto;
import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.model.token.ConfirmationToken;
import com.learn.project.Bootcamp.Project.repository.TokenRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import com.learn.project.Bootcamp.Project.security.SecurityService;
import com.learn.project.Bootcamp.Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
public class ForgotPasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = {"/forgot-password"})
    public ResponseEntity<User> forgotPassword(@RequestBody ObjectNode objectNode) {
        String email = objectNode.get("email").asText();
        System.out.println(email);

        User user=userService.forgotPassword(email);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        System.out.println("User  found");
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = {"/reset-password"})
    public void resetPassword(@RequestParam("token") String confirmationToken,@RequestBody ObjectNode objectNode) {
        ConfirmationToken token = tokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByEmail(token.getUserEntity().getEmail());
            String newPassword = objectNode.get("newPassword").asText();
            String confirmPassword = objectNode.get("confirmPassword").asText();
            if(newPassword.equals(confirmPassword)){
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
            }
            else {
                System.out.println("New Password and Confirm Password do not match");
            }

        } else {
            System.out.println("token invalid");
        }

    }



}
