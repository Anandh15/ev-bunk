package com.SpringBoot.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/register","/api/stations", "/api/login").permitAll()  
                .requestMatchers("/stations").permitAll()
                .requestMatchers("/stations/**").permitAll()  
                .anyRequest().authenticated()  
            )
            .logout(logout -> logout.permitAll()) 
            .cors(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());  
        return http.build();
    }
}
