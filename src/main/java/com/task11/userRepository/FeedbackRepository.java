package com.task11.userRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task11.user.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
	List<Feedback> findByUserId(Long userId);
	
}
