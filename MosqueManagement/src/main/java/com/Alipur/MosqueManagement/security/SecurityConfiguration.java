package com.Alipur.MosqueManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Set configuration on the auth object
		auth.inMemoryAuthentication().withUser("jane").password("alam").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("shah").password("jahan").roles("EDITOR");
			
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/").permitAll().antMatchers("/mosque/admin").authenticated()
//				.antMatchers("/mosque/add/**", "/mosque/save/**", "/mosque/list/","/mosque/admin").hasAnyRole("ADMIN", "MODIFIER")
//				.antMatchers("/mosque/update/**", "/mosque/delete/**").hasRole("ADMIN").and().httpBasic();
		http.authorizeRequests()
		.antMatchers("/").permitAll().antMatchers("/mosque/admin").authenticated()
		.antMatchers("/mosque/add/**", "/mosque/save/**", "/mosque/list/","/mosque/admin").hasAnyRole("ADMIN", "EDITOR")
		.antMatchers("/mosque/update/**", "/mosque/delete/**").hasRole("ADMIN")
			.and()
				.formLogin()
					.and()
						.logout().permitAll()
								.and()
								.exceptionHandling()
								.accessDeniedPage("/403");
	}

	@Bean
	@SuppressWarnings("deprecation")
	public static NoOpPasswordEncoder paswordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
