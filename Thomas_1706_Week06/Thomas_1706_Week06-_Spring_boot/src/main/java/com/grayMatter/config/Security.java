package com.grayMatter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@ComponentScan("com.grayMatter")
public class Security {
 
    @Bean
    public UserDetailsService getUserDetails() {
        UserDetails admin = User.withUsername("Admin").password(encodePassword().encode("Password")).roles("admin").build();
        UserDetails user = User.withUsername("User").password(encodePassword().encode("Password")).roles("user").build();
        return new InMemoryUserDetailsManager(admin, user);
    }
 
    @Bean
    public PasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .httpBasic(); 
        return http.build();
    }
    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeRequests(authz -> authz
//                .requestMatchers("/events/location/**", "/events/date/**", "/events/**/availability").hasAnyRole("user", "admin")
//                .requestMatchers("/events/**").hasRole("admin")
//                .anyRequest().authenticated()
//            )
//            .formLogin()
//            .and()
//            .httpBasic();
//        return http.build();
//    }

}