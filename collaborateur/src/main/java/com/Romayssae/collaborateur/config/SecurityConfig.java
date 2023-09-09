package com.Romayssae.collaborateur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;

import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    //Default User in the system & a custom password
    public InMemoryUserDetailsManager user(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("RomaChan")
                        //.password("{noop}DigInErVa2à2")
                        //Stock in memory the hash not the password itself
                        .password(passwordEncoder().encode("DigInErVa2à2"))
                        .roles("ADMIN", "USER")
                        .authorities("read")
                        .build(),
                User.withUsername("MohamLa")
                        //Stock in memory the hash not the password itself
                        .password(passwordEncoder().encode("DigInErVa2023"))
                        .roles("ADMIN")
                        .authorities("read")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Basic security layer
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(
                new ClearSiteDataHeaderWriter(
                        ClearSiteDataHeaderWriter.Directive.CACHE,
                        ClearSiteDataHeaderWriter.Directive.COOKIES
                )
        );

        http
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .logout((logout) -> logout.addLogoutHandler(clearSiteData));


        return http.build();
    }
}

