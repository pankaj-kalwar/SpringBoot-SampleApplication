package com.beyondalgo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final String HU_REST_RESOURCE_ID = "Microservice_Auth_Resources";
	
    private static final String CLIENTID = "my-trusted-client5";
    private static final String SECRET = "secret123";
    
    private static final String AUTH_SERVER_URL = "localhost:4444/authServer"; 
    
	@Bean
	public ResourceServerTokenServices tokenService() {
	    RemoteTokenServices tokenServices = new RemoteTokenServices();
	    tokenServices.setClientId(CLIENTID);
	    tokenServices.setClientSecret(SECRET);
	    tokenServices.setCheckTokenEndpointUrl("http://"+AUTH_SERVER_URL+"/oauth/check_token");
	    return tokenServices;
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
	    authenticationManager.setTokenServices(tokenService());
	    return authenticationManager;
	}

}
