package com.accolite.restapi_au.service.impl;

import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.repository.UserRepository;
import com.accolite.restapi_au.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User addUser(User user) {
        //Encrypt the password
        String plainPassword = user.getPassword();
        String encryptedPassword = getEncryptedPassword(plainPassword);
        user.setPassword(encryptedPassword);

        //Add to DB
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    private String getEncryptedPassword(String plainPassword) {
        return bCryptPasswordEncoder.encode(plainPassword);
    }
    
    @Override
	public User getUserByEmailId(String email) {
		Optional<User> user= userRepository.findByEmailId(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
//		return user.get(0);
//		return null;
	}
    
    @Override
    public User updateUser(User user) {

        String plainPassword = user.getPassword();
        String encrptedPassword = getEncryptedPassword(plainPassword);
        user.setPassword(encrptedPassword);

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }
    
    @Override
	public String deleteUser(Integer id) {
    	Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            return "No Such User is present";

        userRepository.deleteById(id);
        return "User is Sucessfully Deleted";
		
	}
}
