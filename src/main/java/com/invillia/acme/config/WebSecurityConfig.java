package com.invillia.acme.config;

import org.springframework.context.annotation.Bean;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	private static final String[] AUTH_WHITELIST = {
	// -- swagger ui
	"/v2/api-docs",
	"/swagger-resources",
	"/swagger-resources/**",
	"/configuration/ui",
	"/configuration/security",
	"/swagger-ui.html",
	"/webjars/**",
	"/static/**",
	"/resources/**"
	// other public endpoints of your API may be appended to this array
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/", "/home", "/login", "/logout").permitAll()
	.antMatchers(AUTH_WHITELIST).permitAll()
	.antMatchers("/hello").authenticated()
	.antMatchers("/store/").permitAll()
	.and()
	.formLogin()
	.loginPage("/login").permitAll()
	.and()
	.logout().permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("akuma172").roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}