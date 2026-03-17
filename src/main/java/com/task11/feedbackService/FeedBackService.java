package com.task11.feedbackService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task11.user.Feedback;
import com.task11.userRepository.FeedbackRepository;

@Service
public class FeedBackService {
	@Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback addFeedback(Feedback feedback) {
        feedback.setDate(LocalDateTime.now()); 
        return feedbackRepository.save(feedback);
    }

    
    public Feedback updateFeedback(Long id, String newText) {
        Feedback existing = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
        existing.setFeedbackText(newText);
        existing.setDate(LocalDateTime.now()); // Update time [cite: 24]
        return feedbackRepository.save(existing);
    }

    
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

	
}
