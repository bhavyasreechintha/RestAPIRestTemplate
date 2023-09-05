package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity

@Configuration

@EnableMethodSecurity

public class SecurityConfig {

	@Autowired

	private AppBasicAuthenticationEntryPoint authenticationEntryPoint;

	@Bean

	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().requestMatchers("/public").permitAll().anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(authenticationEntryPoint);
		return http.build();
	}

	@Bean

	public InMemoryUserDetailsManager userDetailsService() {

		UserDetails user = User

				.withUsername("bhavya")

			    .password(passwordEncoder().encode("bhavya@2002")).roles("USER_ROLE")

				.roles("ADMIN")

				.build();

		return new InMemoryUserDetailsManager(user);

	}

	@Bean

	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(8);

	}

}
