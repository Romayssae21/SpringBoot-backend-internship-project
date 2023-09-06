package com.Romayssae.collaborateur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Basic security layer
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize)->
                        authorize.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .build();

    }



}
