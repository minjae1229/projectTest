/*
package com.example.demo9.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request,
                                      HttpServletResponse response,
                                      AuthenticationException exception)
          throws IOException {

    if(exception instanceof UsernameNotFoundException) {
      response.sendRedirect("/message/loginEmailFail");
    }
    else if(exception instanceof BadCredentialsException) {
      response.sendRedirect("/message/loginPwFail");
    }
    else if(exception instanceof DisabledException) {
      response.sendRedirect("/message/memberDelOk");
    }
    else {
      response.sendRedirect("/message/loginFail");
    }
  }
}

*/
