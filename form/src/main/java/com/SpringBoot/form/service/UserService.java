package com.SpringBoot.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot.form.model.User;
import com.SpringBoot.form.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    public void saveUser(User user) {
    	if (!user.getRole().startsWith("ROLE_")) {
            user.setRole("ROLE_" + user.getRole());
        }
        userRepo.save(user);
    }
}
