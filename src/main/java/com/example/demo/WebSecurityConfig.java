package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/hello", "/hello-rest").permitAll()
                .antMatchers("/secure/hello").authenticated()
                .and().formLogin()
                .permitAll()
                .and()

                .logout().permitAll();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

}
