package com.example.padar.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;


@Configuration
public class SpringSecuirtyConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("password")
                .roles("ADMIN")
                .build();
        UserDetails user1 = User.withUsername("user1")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,user1);
    }

    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }
    @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception { http.csrf().disable();
                http.authorizeRequests().antMatchers(HttpMethod.GET).permitAll().and().
                authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().and().
                authorizeRequests().antMatchers(HttpMethod.GET,"/actuator/**").hasAnyRole("ADMIN").and().
                authorizeRequests().antMatchers(HttpMethod.POST).permitAll().and().
                authorizeRequests().antMatchers(HttpMethod.PUT).permitAll().and().
                authorizeRequests().antMatchers(HttpMethod.DELETE).permitAll().
                anyRequest().authenticated().and().httpBasic();
                return http.build();
    }




    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return  (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }

}