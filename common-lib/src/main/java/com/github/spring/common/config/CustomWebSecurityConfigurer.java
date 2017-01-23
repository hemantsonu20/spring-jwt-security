package com.github.spring.common.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter implements RequestMatcher, InitializingBean {

    @Value("${security.ignored}")
    private List<String> ignoredPath;
    
    private OrRequestMatcher matcher;


    private List<RequestMatcher> getAntPathMatcher() {

        List<RequestMatcher> matchers = new ArrayList<>();
        for (String s : ignoredPath) {

            if (StringUtils.isBlank(s)) {
                continue;
            }
            if (s.endsWith("/")) {

                matchers.add(new AntPathRequestMatcher(StringUtils.removeEnd(s, "/")));
            }
            else {
                matchers.add(new AntPathRequestMatcher(StringUtils.join(s, "/")));
            }
            matchers.add(new AntPathRequestMatcher(s));
        }
        return matchers;
    }

   
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
        
        
        super.configure(http);
        http.requestMatcher(this);
    }


    @Override
    public void afterPropertiesSet() throws Exception {

       System.out.println(ignoredPath);
       matcher = new OrRequestMatcher(getAntPathMatcher());
       System.out.println(matcher);
    }

    @Override
    public boolean matches(HttpServletRequest request) {

        System.out.println("called");
        return !matcher.matches(request);
    }
}
