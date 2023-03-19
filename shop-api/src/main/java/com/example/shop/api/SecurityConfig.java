package com.example.shop.api;


import com.example.shop.api.dto.Role;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@Data
public class SecurityConfig {

//    private static final String[] AUTH_WHITELIST = {
//            "/shop"
//    };

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .roles("ADMIN", "USER")
//                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests((auth) ->
                        auth
                                .antMatchers("/admin/**").hasRole("ADMIN")
                                .antMatchers("/user/**").authenticated()
                                .antMatchers("/shop/**").permitAll())

                .formLogin()
                .defaultSuccessUrl("/user", true)

                .and()
                .cors().and()
                .httpBasic(withDefaults())
        ;
        return http.build();
    }

}
