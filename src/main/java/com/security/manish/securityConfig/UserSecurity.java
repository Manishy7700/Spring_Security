package com.security.manish.securityConfig;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurity {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encode) {
		
		UserDetails user=User.withUsername("manish")
				.password(encode.encode("manish"))
				.roles("ADMIN","USER")
				.build();
		return new InMemoryUserDetailsManager(user);
		
	}
//	@Bean
//	private UserDetailsService InMemoryUserDetailsManager(UserDetails user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Bean
	public PasswordEncoder pass() {
		return new BCryptPasswordEncoder();
	}
	//@Bean
	SecurityFilterChain filter(HttpSecurity http) throws Exception {

		return http.csrf().and().cors().disable()
		.authorizeHttpRequests()
		.requestMatchers("/home").permitAll()
		
		.and().formLogin()
		.and().build();
		//http.authorizeHttpRequests().anyRequest().authenticated();
		
		
		
	
		
	}
}
