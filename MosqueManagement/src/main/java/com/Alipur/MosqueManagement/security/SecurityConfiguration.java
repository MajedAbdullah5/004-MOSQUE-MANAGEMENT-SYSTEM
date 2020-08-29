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
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/mosque/admin").authenticated()
		.antMatchers("/mosque/add/**", "/mosque/save/**", "/mosque/list/", "/mosque/list","/mosque/admin","/mosque/admin/","/mosque/orgDonation"
				,"/mosque/orgDonation/","/mosque/personDonation","/mosque/personDonation/"
				,"/mosque/landSale","/mosque/landSale/"
				,"/mosque/unnecessaryEquipmentSale","/mosque/unnecessaryEquipmentSale/"
				,"/mosque/collectionJummah","/mosque/collectionJummah/"
				,"/mosque/specialFitrCollection","/mosque/specialFitrCollection/"
				,"/mosque/specialAdhaCollection","/mosque/specialAdhaCollection/"
				,"/mosque/specialJummahCollection","/mosque/specialJummahCollection/"
				,"/mosque/tarawihExtra","/mosque/tarawihExtra/"
				,"/mosque/social","/mosque/social/"
				,"/mosque/bankWithdrawn","/mosque/bankWithdrawn/"
				,"/mosque/other","/mosque/other/"
				,"/mosque/honor","/mosque/honor/"
				,"/mosque/mobileBill","/mosque/mobileBill/"
				,"/mosque/travelCost","/mosque/travelCost/"
				,"/mosque/generalWage","/mosque/generalWage/"
				,"/mosque/loanPayment","/mosque/loanPayment/"
				,"/mosque/electricityBill","/mosque/electricityBill/"
				,"/mosque/fuelConsumption","/mosque/fuelConsumption/"
				,"/mosque/constructorWage","/mosque/constructorWage/"
				,"/mosque/paintConsumption","/mosque/paintConsumption/"
				,"/mosque/electricEquipment","/mosque/electricEquipment/"
				,"/mosque/purchaseMeterials","/mosque/purchaseMeterials/"
				,"/mosque/miscillaneousCosts","/mosque/miscillaneousCosts/"
				,"/mosque/repair","/mosque/repair/"
				,"/mosque/furniture","/mosque/furniture/"
				,"/mosque/entertainmentCons","/mosque/entertainmentCons/"
				,"/mosque/transportation","/mosque/transportation/"
				,"/mosque/social","/mosque/social/"
				,"/mosque/social","/mosque/social/"
				
				
				)
		.hasAnyRole("ADMIN", "EDITOR")
		.antMatchers("/mosque/update/**", "/mosque/delete/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/mosque/login")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/mosque/403");
	}

	@Bean
	@SuppressWarnings("deprecation")
	public static NoOpPasswordEncoder paswordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
