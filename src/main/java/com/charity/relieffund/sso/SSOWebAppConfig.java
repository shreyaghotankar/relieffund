package com.charity.relieffund.sso;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;

import com.charity.relieffund.customfilter.OAuth2AuthenticationFilter;

import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;





@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SSOWebAppConfig extends WebSecurityConfigurerAdapter{
	
	@Value("${logout.uri}")
	private String logoutUri;
	
	 @Autowired
	    private OAuth2AuthenticationFilter oAuth2AuthenticationFilter;
	
	@Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler logoutHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        logoutHandler.setPostLogoutRedirectUri(logoutUri);
        return logoutHandler;
    }
	
	@Override  
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()  
        .antMatchers("/").permitAll()  
        .anyRequest().authenticated()
        .and()
        .addFilterAfter(oAuth2AuthenticationFilter, OAuth2LoginAuthenticationFilter.class)
        //logout
        .logout().logoutSuccessUrl("/")
        .and().logout().logoutSuccessHandler(oidcLogoutSuccessHandler())

        // enable OAuth2/OIDC
        .and().oauth2Login();
        
        
    }
}
