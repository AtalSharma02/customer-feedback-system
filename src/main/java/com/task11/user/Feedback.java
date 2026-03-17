package com.task11.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="feedback")

public class Feedback {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(columnDefinition = "TEXT", nullable = false)
private String feedbackText;

@Column(nullable = false)
private LocalDateTime date; 


@ManyToOne
@JoinColumn(name = "user_id")
private User user;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getFeedbackText() {
	return feedbackText;
}


public void setFeedbackText(String feedbackText) {
	this.feedbackText = feedbackText;
}


public LocalDateTime getDate() {
	return date;
}


public void setDate(LocalDateTime date) {
	this.date = date;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}

}

