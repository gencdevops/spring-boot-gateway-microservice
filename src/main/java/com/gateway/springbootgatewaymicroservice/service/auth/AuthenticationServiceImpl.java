package com.gateway.springbootgatewaymicroservice.service.auth;


import com.gateway.springbootgatewaymicroservice.model.User;
import com.gateway.springbootgatewaymicroservice.security.UserPrincipal;
import com.gateway.springbootgatewaymicroservice.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public String signInAndReturnJwt(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUserName() , signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return jwtProvider.generateToken(userPrincipal);
    }
}
