package com.task11.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task11.feedbackService.FeedBackService;
import com.task11.user.Feedback;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/feedback")
public class FeedBackController {
	@Autowired
    private FeedBackService feedbackService;	

    
	@PostMapping("/add")
    public String addFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.addFeedback(feedback);
       
        return "redirect:/api/feedback/admin"; 
    }


	@GetMapping("/admin")
	public String showAdminDashboard(HttpServletRequest request) {
	    
	    //feedbackService.getAllFeedbacks();
	    	
	       request.setAttribute("feedbacks",feedbackService.getAllFeedbacks());
	  
	    return "admin"; 
	}
	
    @GetMapping("/delete/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/api/feedback/admin";
    }
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable Long id, HttpServletRequest request) {
        Feedback fb = feedbackService.getFeedbackById(id); 
        request.setAttribute("feedback", fb);
        return "edit-feedback"; 
    }
    @PostMapping("/update")
    public String updateFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.addFeedback(feedback); 
        return "redirect:/api/feedback/admin";
    }
    @GetMapping("/view/{id}")
    public String viewFeedback(@PathVariable Long id, HttpServletRequest request) {
        Feedback fb = feedbackService.getFeedbackById(id);
        request.setAttribute("feedback", fb);
        return "view-feedback"; 
    }
}
