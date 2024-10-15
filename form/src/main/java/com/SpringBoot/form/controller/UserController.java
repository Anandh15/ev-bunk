package com.SpringBoot.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.SpringBoot.form.dto.LoginDto;
import com.SpringBoot.form.dto.RegisterDto;
import com.SpringBoot.form.model.User;
import com.SpringBoot.form.service.UserService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) {
        try {
            if (userService.findByEmail(registerDto.getEmail()) != null) {
                return ResponseEntity.badRequest().body("Error: Email is already in use!");
            }

            User user = new User();
            user.setFirstname(registerDto.getFirstname());
            user.setLastname(registerDto.getLastname());
            user.setEmail(registerDto.getEmail());

            String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
            user.setPassword(encodedPassword);

            String role = registerDto.getRole();
            if (role == null || role.isEmpty()) {
                user.setRole("ROLE_User");
            } else if (!role.startsWith("ROLE_")) {
                user.setRole("ROLE_" + role);
            } else {
                user.setRole(role);
            }


            userService.saveUser(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: Registration failed! " + e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        User user = userService.findByEmail(loginDto.getEmail());

        if (user != null && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            logger.info("Login successful for user - {}", loginDto.getEmail());

            return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "role", user.getRole() 
            ));
        }

        logger.warn("Invalid login attempt for user - {}", loginDto.getEmail());
        return ResponseEntity.badRequest().body("Invalid Credentials");
    }

    
    @GetMapping("/user/role")
    public ResponseEntity<?> getUserRole(Authentication authentication) {
        String role = authentication.getAuthorities().stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .findFirst()
                                    .orElse("ROLE_User");
        return ResponseEntity.ok(Map.of("role", role));
    }


}
