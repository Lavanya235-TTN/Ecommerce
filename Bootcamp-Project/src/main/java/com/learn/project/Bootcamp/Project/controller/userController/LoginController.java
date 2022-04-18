package com.learn.project.Bootcamp.Project.controller.userController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.learn.project.Bootcamp.Project.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private SecurityService securityService;

//    @PostMapping("/login")
//    public String login(@RequestBody String email,@RequestBody String password) {

        @PostMapping("/login")
        public String login(@RequestBody ObjectNode objectNode) {
            String email = objectNode.get("email").asText();
            String password = objectNode.get("password").asText();

            boolean loginResponse = securityService.login(email, password);
            if (loginResponse) {

                return "Done";
            }
            return "Not exist";
    }
}
