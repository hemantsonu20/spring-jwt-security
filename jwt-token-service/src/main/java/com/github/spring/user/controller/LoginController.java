package com.github.spring.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.spring.common.Role;
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
    private String username;
    
    @Value("${jwt.user.password}")
    private String password;
    

    @RequestMapping(method = RequestMethod.POST)
    public JwtResponse login(@Valid @RequestBody LoginInfo loginInfo) {

        return new JwtResponse()
                .setJwtToken(tokenService.encodeToken( validateAndget(loginInfo), jwtSecret));
    }

    private UserInfo validateAndget(LoginInfo loginInfo) {

        if(loginInfo.getUsername().equals(username) && loginInfo.getPassword().equals(password)) {
         
            return new UserInfo().setId(username).setName(username).setUserRole(Role.ADMIN);
        }
        throw new WebServiceException(HttpStatus.UNAUTHORIZED, "username or password not valid");
    }
}
