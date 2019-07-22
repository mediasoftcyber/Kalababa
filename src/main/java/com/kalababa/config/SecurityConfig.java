package com.kalababa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private static final String  USERS_BY_UNAME="SELECT	email_Id, password, enabled FROM users WHERE email_Id=? ";
	private static final String  ROLES_BY_UNAME="SELECT emailId, authorities FROM authorities WHERE emailId =?";
	
	
	@Autowired
	private DataSource ds;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth
		.jdbcAuthentication().passwordEncoder(encoder).dataSource(ds)
		.usersByUsernameQuery(USERS_BY_UNAME)
		.authoritiesByUsernameQuery(ROLES_BY_UNAME)
		.and()
		.inMemoryAuthentication()
		.withUser("admin@redojet.com")
		.password("{noop}admin")
		.authorities("ROLE_ADMIN");
	}
	
	@Override
	public  void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 .antMatchers("/index/**")
		  .access("permitAll")
		 .antMatchers("/index1/**")
		  .access("permitAll")
		 .antMatchers("/cart/**")
		  .access("permitAll")
		 .antMatchers("/add*/**")
		  .access("hasRole('ROLE_ADMIN')")
		 .antMatchers("/get*/**")
		  .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
		 .antMatchers("/admin*/**")
		  .access("hasRole('ROLE_ADMIN')")
		 .and()
		  .formLogin().loginPage("/login").loginProcessingUrl("/login")
		  	.defaultSuccessUrl("/index1")
		 .and().logout().logoutSuccessUrl("/login?logout=y").and().csrf().disable();
	
	}
	
}
