package com.charity.relieffund.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.charity.relieffund.customfilter.OAuth2AuthenticationFilter;

@Configuration
public class GenericConfig {
  @Bean
  public OAuth2AuthenticationFilter oAuth2AuthenticationFilter() {
	  return new OAuth2AuthenticationFilter();
  }
}
