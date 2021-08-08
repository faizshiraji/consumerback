package com.consumerback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.consumerback.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private CustomUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public PasswordEncoder	passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());

	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception 
	{
		return super.authenticationManagerBean();
		
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
	
	// We don't need CSRF for this. 
		
	httpSecurity.csrf().disable()
			// dont authenticate this particular request
	.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
	.antMatchers("/admin/**").hasAnyRole("USER", "ADMIN")
	.antMatchers("/authenticate", "/register", "/admin/**").permitAll()
	// all other request need to be authenticated
	.anyRequest().authenticated().and()
	.formLogin().loginPage("/admin/login").permitAll()
	.successForwardUrl("/admin/index")
	.and()
	.logout().permitAll()
	.logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
	.logoutSuccessUrl("/admin/login").
	and()
	// make sure we use stateless session; session won't be used to 
	// store user's state. 
	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	.and().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
}

	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/v2/api-docs",
                                 "/configuration/ui",
                                 "/swagger-resources/**",
                                 "/configuration/security",
                                 "/swagger-ui.html",
                                 "/webjars/**",
                                 "/css/**",
                                 "/js/**",
                                 "/img/**",
                                 "/font-awesome/**");
  }
	
}
