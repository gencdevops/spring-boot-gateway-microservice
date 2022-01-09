package com.gateway.springbootgatewaymicroservice.service.auth;

import com.gateway.springbootgatewaymicroservice.model.User;

public interface IAuthenticationService {
    String signInAndReturnJwt(User signInRequest);
}
