package com.bootcamp.customer.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class CustomerConfiguration {
	  @Bean
	    public UserDetailsService userDetailsService() {
	        return new CustomerServiceConfig();
	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    private static final String[] WHITE_LIST_URL = {
	    		"/*",
	    		"/product-detail/**",
	    		"/vendor/**",
	    		"/shop/**",
	    		"/find-products/**"
				
		 };
	    @Bean
	     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			 AuthenticationManagerBuilder authenticationManagerBuilder
	         = http.getSharedObject(AuthenticationManagerBuilder.class);

			 authenticationManagerBuilder.userDetailsService(userDetailsService())
	         .passwordEncoder(passwordEncoder());
			 AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
		       http.csrf(AbstractHttpConfigurer::disable).
		       	authorizeHttpRequests(req -> req.requestMatchers(WHITE_LIST_URL).permitAll()
		       			.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().anyRequest().authenticated()).
		       	formLogin(login ->login.loginPage("/login")
                        .loginProcessingUrl("/do-login")
                        .defaultSuccessUrl("/index", true)
                        .permitAll())
		       	.logout(logout ->logout.invalidateHttpSession(true)
		       			.clearAuthentication(true)
		       			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		       			.logoutSuccessUrl("/login?logout")
		       			.permitAll())
		        .authenticationManager(authenticationManager)
	            .sessionManagement(session ->
	                    session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
	            )
		       	;
		        return http.build();
		    }
}
