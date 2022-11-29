package com.tcs.SecurityExampleWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().
//		anyRequest().authenticated().and().httpBasic();
		
//		http.authorizeRequests().
//		anyRequest().authenticated().and().formLogin();
		
		http.authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .permitAll()     
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.inMemoryAuthentication()
	       .passwordEncoder(new BCryptPasswordEncoder())
	           .withUser("pashu")
	           .password(passwordEncoder().encode("123"))
	           .roles("ADMIN")
	       .and()
	           .withUser("pashu1")
	           .password(passwordEncoder().encode("456"))
	           .roles("USER")
	       ;
	}

}
