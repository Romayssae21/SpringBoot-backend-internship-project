package com.Romayssae.collaborateur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
    public HttpSecurity securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .formLogin(form -> form
                        .loginPage("/api/v1")
                        .permitAll()
                );
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                //.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.build();

    }



}
