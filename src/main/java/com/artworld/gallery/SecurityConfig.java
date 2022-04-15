package com.artworld.gallery;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//When Spring Security dependency is added onto a pom file,
	//it immediately launches default settings of securing all endpoints
	//and adding a login page while the console gives a password
	//However, this is a class, based on Spring's WebSecurityConfigurerAdapter,
	//that is required to customize its detailed configurations.
	//The two annotations above are discarding the default settings.
	
	
	//This configuration method defines which endpoints are secured and which not.
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/","/home").permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/lobby",true)
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	public UserDetailsService uds() {
		UserDetails user =
				User.withDefaultPasswordEncoder()
				.username("Tommi")
				.password("1234")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
