package com.Romayssae.collaborateur.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    //Default User in the system & a custom password
    public InMemoryUserDetailsManager user(PasswordEncoder passwordEncoder){
        return new InMemoryUserDetailsManager(
                User.withUsername("RomaChan")
                        //.password("{noop}DigInErVa2à2")
                        .password(passwordEncoder().encode("DigInErVa2à2"))
                        .roles("ADMIN")
                        .authorities("read")
                        .build()
        );
    }

    //Define other user:

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .authorizeRequests(auth-> auth
                        .anyRequest().authenticated()
                )
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }



}
