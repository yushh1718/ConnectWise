package com.ConnectWise.controllers;

import com.ConnectWise.entities.User;
import com.ConnectWise.forms.UserForm;
import com.ConnectWise.helper.Message;
import com.ConnectWise.helper.MessageType;
import com.ConnectWise.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        // System.out.println("Home Page Handler");

        // sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn Code With Me");
        model.addAttribute("githubRepo", "https://github.com/sdmg15/Best-websites-a-programmer-should-visit");

        return "home";
    }

    // about route

    @RequestMapping("/about") 
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("About Page Loading");
        return "about";
    }


    // services
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services Page Loading");
        return "services";
    }

    // contact
    @GetMapping("/contact")
    public String contact(){
        return new String("contact");
    }

    // login
    @GetMapping("/login")
    public String login(){
        return new String("login");
    }

    // register
    @GetMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        // default data bhi daal sakte hai;
        model.addAttribute("userForm", userForm);

        return "register";
    }

    // processing register
    @RequestMapping(value="/do-register", method= RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("processing register");
        // fetch form data
        // --> create UserForm class
        System.out.println(userForm);

        // validate form data
        if(rBindingResult.hasErrors())
            return "register";

        // save to database
        // --> create userService

        /*User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .build();*/
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setEnabled(false);
        user.setPhoneNumber(userForm.getPhoneNumber());

        user.setProfilePic("https://images.unsplash.com/photo-1593085512500-5d55148d6f0d?q=80&w=2080&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");


        User savedUser = userService.saveUser(user);
        System.out.println("user saved");

        // show message = "Registration successful"
        // add the message
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);

        // redirect to signup page
        return "redirect:/register";
    }

}