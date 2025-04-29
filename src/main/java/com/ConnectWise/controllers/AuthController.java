package com.ConnectWise.controllers;

import com.ConnectWise.entities.User;
import com.ConnectWise.helper.Message;
import com.ConnectWise.helper.MessageType;
import com.ConnectWise.repositories.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    // verify email
    @Autowired
    private UserRepo userRepo;

    @GetMapping("verify-email")
    public String verifyEmail(
            @RequestParam("token") String token, HttpSession session){

        User user = userRepo.findByEmailToken(token).orElse(null);
        if(user != null) {

            if(user.getEmailToken().equals(token)){
                user.setEmailVerified(true);
                user.setEnabled(true);
                userRepo.save(user);

                session.setAttribute("message", Message.builder()
                        .content("Your email is verified. Now you can login.")
                        .type(MessageType.green).build());

                return "success_page";
            }
        session.setAttribute("message", Message.builder()
                .content("Email not verified! Link is not associated with user.")
                .type(MessageType.red).build());
        return "error_page";
        }
        session.setAttribute("message", Message.builder()
                .content("Email not verified! Link is not associated with user.")
                .type(MessageType.red).build());
        return "error_page";
    }
}
