// Pair Programmed with Jacob

package com.jacob.loginandreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jacob.loginandreg.models.LoginUser;
import com.jacob.loginandreg.models.User;
import com.jacob.loginandreg.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserService() {}
	
	public User registerUser (User registeringUser) {
		String hashed = BCrypt.hashpw(registeringUser.getPassword(), BCrypt.gensalt());
		registeringUser.setPassword(hashed);
		return userRepo.save(registeringUser);
	}
	
	public User getUser(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return user.isPresent() ? user.get() : null;
	}
	
	public User getUser(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	
	public User login(LoginUser loginUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		
		User existingUser = getUser(loginUser.getEmail());
		if(existingUser == null) {
			result.rejectValue("email", "Unique" ,"Unknown email");
			return null;
		}
		if(!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
			result.rejectValue("password", "Matches" ,"Incorrect password");
			return null;
		}
		return existingUser;
	}


}
