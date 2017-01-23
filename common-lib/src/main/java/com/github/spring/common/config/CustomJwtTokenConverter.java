package com.github.spring.common.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.github.spring.common.UserInfo;

/**
 * This bean is needed to attach our own data to the authentication.
 * 
 * @author hemant
 *
 */
@Component
public class CustomJwtTokenConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public void configure(JwtAccessTokenConverter converter) {

        converter.setAccessTokenConverter(this);
    }

    /**
     * Fetch usr details from the token map, create your bean and attach it to
     * oauth object.
     * 
     */
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {

        OAuth2Authentication auth = super.extractAuthentication(map);
        auth.setDetails(getUserInfo(map));
        return auth;
    }

    /**
     * Create {@link UserInfo} bean from the jwt claim map
     * 
     * @param map
     * @return
     */
    private UserInfo getUserInfo(Map<String, ?> map) {

        UserInfo info = new UserInfo();
        info.setName(getObject(map, "user_name"));
        info.setAuthorities(getObject(map, "authorities"));
        return info;
    }

    @SuppressWarnings("unchecked")
    private static <T> T getObject(Map<String, ?> map, String key) {

        return (T) map.get(key);
    }
}
