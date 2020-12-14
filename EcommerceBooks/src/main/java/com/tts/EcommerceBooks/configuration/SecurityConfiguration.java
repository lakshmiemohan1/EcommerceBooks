package com.tts.EcommerceBooks.configuration;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tts.EcommerceBooks.service.UserService;

   @Configuration
	 @EnableWebSecurity
	 public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 @Autowired
	 private DataSource dataSource; 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
		 auth.jdbcAuthentication().dataSource(dataSource);
	 }
	  
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
      	 http
	      .authorizeRequests()
	      	 .antMatchers("/console/**").permitAll()
	          .antMatchers("/cart").authenticated()
	          .and().formLogin()
	          .loginPage("/signin")
	          .loginProcessingUrl("/login")
	          .and().logout()
              .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
	          .logoutSuccessUrl("/");
	 	
	 	
	 	http.
	     authorizeRequests()
	     .antMatchers("/console/**").permitAll()
	     .antMatchers("/signin").permitAll()
	     .antMatchers("/signup").permitAll()
	     .antMatchers("/").permitAll()
	     .antMatchers("/product").permitAll()
	     .antMatchers("/product/{id}").permitAll()
	     .antMatchers("/cart").permitAll()
	     .antMatchers("/resources/**", "/static/**",  "/images/**").permitAll()
	     .antMatchers().hasAuthority("USER").anyRequest()
	     .authenticated().and().csrf().disable().formLogin()
	     .loginPage("/signin").failureUrl("/signin?error=true")
	     

	     //.antMatchers().hasAuthority("USER").anyRequest()
	    // .authenticated().and().csrf().disable().formLogin()
	     .loginPage("/signin")
	     .loginProcessingUrl("/login")
	     
	     .defaultSuccessUrl("/products")
	     .usernameParameter("username")
	     .passwordParameter("password")
	   
	     
	     .and().logout()
	     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	     .logoutSuccessUrl("/").and().exceptionHandling();

	 http.headers().frameOptions().disable();
	  
	 }
	 @Override
	 public void configure(WebSecurity web) throws Exception {
	     web
	             .ignoring()
	             .antMatchers("/resources/**", "/static/**",  "/images/**");
	 }     
	 }

