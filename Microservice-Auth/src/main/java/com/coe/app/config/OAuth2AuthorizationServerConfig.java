package com.coe.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.coe.app.constants.Authorities;
import com.coe.app.models.Authority;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String HU_REST_RESOURCE_ID = "Microservice_Auth_Resources";
	
    private static final String CLIENTID = "my-trusted-client5";
    private static final String SECRET = "secret123";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTokenStore tokenStore() {
		// access and refresh tokens will be maintain in database
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	protected AuthorizationCodeServices authorizationCodeServices() {
		return new JdbcAuthorizationCodeServices(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// endpoints.authenticationManager(authenticationManager);
		
		// === Working line 
		endpoints.authorizationCodeServices(authorizationCodeServices()).authenticationManager(authenticationManager).tokenStore(tokenStore()).approvalStoreDisabled();
		// == End of working line
		
		//endpoints.authorizationCodeServices(authorizationCodeServices()).authenticationManager(authenticationManager).tokenStore(tokenStore()).approvalStoreDisabled();
		//endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
		
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// New Code 
		//security.allowFormAuthenticationForClients();
		// Reference : https://github.com/royclarkson/spring-rest-service-oauth/issues/28
		security.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// @formatter:off
		/*
		 * clients.inMemory() .withClient("client-with-registered-redirect")
		 * .authorizedGrantTypes("authorization_code")
		 * .authorities("ROLE_CLIENT") .scopes("read", "trust")
		 * .resourceIds(HU_REST_RESOURCE_ID)
		 * .redirectUris("http://localhost:5555/oauth/token")
		 * .secret("secret123") .and() .withClient("my-client-with-secret")
		 * .authorizedGrantTypes("client_credentials", "password")
		 * .authorities("ROLE_CLIENT") .scopes("read")
		 * .resourceIds(HU_REST_RESOURCE_ID) .secret("secret");
		 */

		System.out.println("\n\nClient Authentication Process......\n\n");
		
		
		// if want to manage everything in data base
		//clients.jdbc(dataSource); 
		
		
		// ==== Working Code ===
		
		clients.jdbc(dataSource)
			.withClient(CLIENTID)
				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
				.authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name(), "ROLE_TRUSTED_CLIENT")
				.scopes("read", "write", "trust")
				.resourceIds(HU_REST_RESOURCE_ID)
				.secret(SECRET)
				.accessTokenValiditySeconds(200)
		
		// ===== End of working code====		
				
		/*.and()
			.withClient("my-client-with-registered-redirect2")
				.authorizedGrantTypes("authorization_code")
				.authorities("ROLE_CLIENT")
				.scopes("read", "trust")
				.resourceIds(HU_REST_RESOURCE_ID)
				.redirectUris("http://anywhere?key=value")
		.and()
			.withClient("my-client-with-secret2")
				.authorizedGrantTypes("client_credentials", "password")
				.authorities("ROLE_CLIENT")
				.scopes("read")
				.resourceIds(HU_REST_RESOURCE_ID)
				.secret("secret");*/
				;
		// @formatter:on
	}
}
