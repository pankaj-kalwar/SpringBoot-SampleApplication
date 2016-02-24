package com.coe.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter{

	private static final String HU_REST_RESOURCE_ID = "Microservice_Auth_Resources";
	
	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources)
			throws Exception {
		resources.resourceId(HU_REST_RESOURCE_ID);//.stateless(false);
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//define URL patterns to enable OAuth2 security 

		System.out.println("setting .... matchers....");
		
		http
			/*.requestMatchers().antMatchers("/")
		.and()*/
			.authorizeRequests()
				.antMatchers("/hello", "/userService/**", "/callUserService", "/callTaskService").permitAll()
				.antMatchers("/secure/**").authenticated()
				//.antMatchers("/callTaskService/**").authenticated()
				//.antMatchers("/callUserService/**").authenticated()
				.antMatchers("/auth/**").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))")
				.antMatchers("/test").access("#oauth2.hasScope('read')")
				/*.antMatchers("/taskService/**").authenticated()
				.antMatchers("/task").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_ADMIN'))")
				.antMatchers("/userService/**").authenticated()
				.antMatchers("/user").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))")*/
				.and()
				.csrf().disable();
				
				//.access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))");
		 // @formatter:off
        /*http
        // Just for laughs, apply OAuth protection to only 2 resources
        .requestMatchers().antMatchers("/","/admin/beans").and()
        .authorizeRequests()
        .anyRequest().access("#oauth2.hasScope('read')"); //[4]
*/        // @formatter:on
		
	}
	
	/*@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
					.loginPage("/login").failureUrl("/login?error").permitAll().and()
					.logout().permitAll();
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("admin").password("admin")
					.roles("ADMIN", "USER").and().withUser("user").password("user")
					.roles("USER");	
		}

	}*/
	
	/*@Autowired
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
			auth.jdbcAuthentication().dataSource(dataSource).withUser("pk")
					.password("pk").roles("USER");
			// @formatter:on
	}*/

}
