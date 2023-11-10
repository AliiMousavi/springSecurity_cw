package com.example.demo.config;

import com.example.demo.service.impl.UserDetailsServiceImpl;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Config {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
                                                               UserDetailsServiceImpl userDetailsService) {
        DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
        daoAuthProvider.setPasswordEncoder(passwordEncoder);
        daoAuthProvider.setUserDetailsService(userDetailsService);
        return daoAuthProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ,
                                                   AuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests( a -> a.requestMatchers("/api/v1/admin").hasRole("ADMIN"))
                .authorizeHttpRequests( a -> a.requestMatchers("/api/v1/customer").hasRole("CUSTOMER"))
                .authorizeHttpRequests( a -> a.requestMatchers("/api/v1/expert").hasRole("EXPERT"))
//                .authorizeHttpRequests(a -> a.requestMatchers().permitAll())
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .build();

    }
}
