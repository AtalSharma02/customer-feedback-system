package com.task11.feedbackService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task11.user.User;
import com.task11.userRepository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    
    public User registerUser(User user) {
        
        return userRepository.save(user);
    }
    public boolean loginUser(String username, String password) {
       
        Optional<User> userFound = userRepository.findByUsername(username);

        if (userFound.isPresent()) {
            User user = userFound.get();
            
            return user.getPassword().equals(password);
        }
        
        return false;
    }
    
}
