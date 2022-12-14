package com.study.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	WebSecurityCustomizer webSecurityConfig() {
		return web -> web.ignoring()
						.antMatchers("/images/**")
						.antMatchers("/css/**")
						.antMatchers("/js/**")
						.antMatchers("/favicon/**")
						.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.cors()
					.and()
					.csrf()
					.disable()
					.authorizeRequests()
						.antMatchers("/").permitAll()
						.antMatchers("/member/login").permitAll()
						.antMatchers("/member/join").permitAll()
						.antMatchers("/qna/list","/qna/detail").permitAll()
						.anyRequest().authenticated()
						.and()
					.formLogin()
						.loginPage("/member/login")
						.usernameParameter("id")
						.failureUrl("/member/login")
						.defaultSuccessUrl("/")
						.permitAll()
						.and()
					.logout()
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.permitAll();
						
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder geEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
