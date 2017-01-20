package com.github.spring.common.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.github.spring.common.UserInfo;

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

    private UserInfo getUserInfo(Map<String, ?> map) {

        UserInfo info = new UserInfo();
        info.setId(getObject(map, "id"));
        info.setName(getObject(map, "name"));
        info.setUserRole(getObject(map, "userRole"));
        return info;
    }

    @SuppressWarnings("unchecked")
    private static <T> T getObject(Map<String, ?> map, String key) {

        return (T) map.get(key);
    }
}
