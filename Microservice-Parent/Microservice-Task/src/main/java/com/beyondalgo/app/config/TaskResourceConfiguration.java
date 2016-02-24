package com.beyondalgo.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableResourceServer
public class TaskResourceConfiguration extends ResourceServerConfigurerAdapter{

	private static final String HU_REST_RESOURCE_ID = "Microservice_Auth_Resources";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources)
			throws Exception {
		resources.resourceId(HU_REST_RESOURCE_ID);//.stateless(false);
		//resources.tokenStore(tokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		
		
		 http
	     .authorizeRequests()
	     	.antMatchers("/**").authenticated()
	     .and()
	     	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		/*http.requestMatchers()
			.antMatchers("/**")
		.and()
			.authorizeRequests()
				.anyRequest()
					.authenticated()
					.antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
		            .antMatchers(HttpMethod.OPTIONS, "/**").access("#oauth2.hasScope('read')")
		            .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
		            .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
		            .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
		            .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')");*/
		// @formatter:on
	}
}
