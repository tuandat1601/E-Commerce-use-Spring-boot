package com.bootcamp.admin.config;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AdminConfiguration {
	 @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	       http.csrf(AbstractHttpConfigurer::disable).
	       authorizeHttpRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
	       requestMatchers("/vendor/**").permitAll().
	       requestMatchers("/hello/**").permitAll().
	       and().
	       	formLogin(form -> form
	       			.loginPage("/login")
	       			.defaultSuccessUrl("/clubs")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login?error=true")
	       			.permitAll());
	        return http.build();
	    }
}
