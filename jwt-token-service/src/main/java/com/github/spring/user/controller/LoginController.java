package com.github.spring.user.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.spring.common.UserInfo;
import com.github.spring.common.WebServiceException;
import com.github.spring.common.token.TokenService;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @Value("${jwt.token.key}")
    private String jwtSecret;

    @Value("${jwt.user.name}")
    private String user;

    @Value("${jwt.user.password}")
    private String userPassword;

    @Value("${jwt.admin.name}")
    private String admin;

    @Value("${jwt.admin.password}")
    private String adminPassword;

    List<String> userAuthorities = Arrays.asList("ROLE_USER");
    List<String> adminAuthorities = Arrays.asList("ROLE_ADMIN", "ROLE_USER");

    @RequestMapping(method = RequestMethod.POST)
    public JwtResponse login(@Valid @RequestBody LoginInfo loginInfo) {

        return new JwtResponse().setJwtToken(tokenService.encodeToken(validateAndget(loginInfo), jwtSecret));
    }

    private UserInfo validateAndget(LoginInfo loginInfo) {

        if (loginInfo.getUsername().equals(user) && loginInfo.getPassword().equals(userPassword)) {

            // if user login
            return new UserInfo().setName(user).setAuthorities(userAuthorities);
        }
        else if (loginInfo.getUsername().equals(admin) && loginInfo.getPassword().equals(adminPassword)) {

            // if admin login
            return new UserInfo().setName(admin).setAuthorities(adminAuthorities);
        }
        else {
            throw new WebServiceException(HttpStatus.UNAUTHORIZED, "username or password not valid");
        }
    }
}
