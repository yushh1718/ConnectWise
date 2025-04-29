package com.ConnectWise.controllers;

import com.ConnectWise.entities.User;
import com.ConnectWise.helper.Helper;
import com.ConnectWise.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class RootController {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;


    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication){

        if(authentication == null) return;

        System.out.println("Adding logged in user info to the model");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in: {} ", username);

        // get user from db
        User user = userService.getUserByEmail(username);
        System.out.println(user);

            System.out.println(user.getName());
            System.out.println(user.getEmail());
            model.addAttribute("loggedInUser", user);

    }

}
