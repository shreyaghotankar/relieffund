package com.charity.relieffund.customfilter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;


import java.util.List;

public class OAuth2AuthWrapperToken extends OAuth2AuthenticationToken {

    public OAuth2AuthWrapperToken(OAuth2AuthenticationToken token, List<GrantedAuthority> authorityList) {
        super(token.getPrincipal(), authorityList, token.getAuthorizedClientRegistrationId());
    }
}
