package com.task11.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.task11.feedbackService.UserService;
import com.task11.user.User;
import jakarta.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;
    
    

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; 
    }


    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login"; }

   
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        boolean success = userService.loginUser(username, password);
        if (success) {
            return "redirect:/feedback";
            
        } else {
            request.setAttribute("error", "Invalid Credentials!");
            return "login";
        }
    }
    @GetMapping("/feedback")
    public String showFeedbackPage() {
        return "feedback"; 
    }
    
}

