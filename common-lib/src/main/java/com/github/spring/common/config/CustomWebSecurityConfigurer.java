package com.github.spring.common.config;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter implements InitializingBean {

    @Value("${security.ignored:}")
    private String[] currentIgnoredPath;

    private String[] newIgnoredPath;

    private static final String SLASH = "/";
    private static final String ALL_MATCHER = "**";

    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
        if(newIgnoredPath.length > 0) {
            web.ignoring().antMatchers(newIgnoredPath);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        newIgnoredPath = new String[currentIgnoredPath.length];
        int i = 0;
        for (String s : currentIgnoredPath) {

            if (alternatePathNeeded(s)) {
                newIgnoredPath[i++] = getAlternatePath(s);
            }
        }
        newIgnoredPath = Arrays.copyOf(newIgnoredPath, i);
        System.out.println(Arrays.toString(newIgnoredPath));
    }

    /**
     * Method checks whether ignored path is an all ant matcher (ends with /**),
     * in that case no need to ignore alternate path as it will be obsolete.
     * 
     * @param s
     * @return
     */
    private boolean alternatePathNeeded(String s) {

        if (StringUtils.isBlank(s)) {
            return false;
        }
        else if (s.endsWith(ALL_MATCHER)) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * If string ends with "/" method returns removing the "/" and if it
     * doesn't, it returns appending the "/"
     * 
     * @param s
     * @return
     */
    private String getAlternatePath(String s) {

        if (s.endsWith(SLASH)) {
            return StringUtils.removeEnd(s, SLASH);
        }
        else {
            return StringUtils.join(s, SLASH);
        }
    }
}
