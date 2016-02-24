package com.coe.app;

import static org.junit.Assert.assertTrue;

import org.springframework.boot.test.SpringApplicationConfiguration;

import sparklr.common.AbstractAuthorizationCodeProviderTests;

/**
 * @author Dave Syer
 */
@SpringApplicationConfiguration(classes = Application.class)
public class AuthorizationCodeProviderTests extends AbstractAuthorizationCodeProviderTests {

	protected void verifyAuthorizationPage(String page) {
		assertTrue(page.contains("action='/oauth/authorize'"));
		assertTrue(page.contains("<input name='user_oauth_approval'"));
		assertTrue(page.contains("type='radio")); // approval store
	}

}