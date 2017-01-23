package com.github.spring.common.token;

import org.springframework.http.HttpStatus;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.security.jwt.crypto.sign.MacSigner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.common.UserInfo;
import com.github.spring.common.WebServiceException;

/**
 * Class to encode and decode jwt token with jwt secret key
 * 
 * @author pratapihemant.patel
 *
 */
public class TokenService {

    private ObjectMapper mapper = new ObjectMapper();
    
    public String encodeToken(UserInfo info, String jwtSecret) {

        try {
            return JwtHelper.encode(mapper.writeValueAsString(info), new MacSigner(jwtSecret)).getEncoded();

        } catch (Exception e) {
            throw new WebServiceException("unable to generate jwt", e);
        }
    }

    public UserInfo decodeToken(String jwtToken, String jwtSecret) {

        
        try {
            Jwt jwt = JwtHelper.decodeAndVerify(jwtToken, new MacSigner(jwtSecret));
            return mapper.readValue(jwt.getClaims(), UserInfo.class);
        } 
        catch(InvalidSignatureException | IllegalArgumentException e) {
            throw new WebServiceException(HttpStatus.UNAUTHORIZED, "unable to generate jwt", e);
        }
        
        catch (Exception e) {
            throw new WebServiceException("unable to decode jwt", e);
        }
    }
}
