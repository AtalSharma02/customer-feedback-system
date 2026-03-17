package com.task11.userRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task11.user.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
    Optional<User> findByUsername(String username);
    
    
    Boolean existsByEmail(String email);
}
