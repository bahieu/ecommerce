package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Component
public class AuthenticationSuccessHandlerCustom implements AuthenticationSuccessHandler {
    private static final String STUDENT_ROLE = "User";
    private static final String TEACHER_ROLE = "Admin";
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        boolean isAdminRole = false;
        boolean isCustomerRole = false;

        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : grantedAuthorities) {
            if (grantedAuthority.getAuthority().equals(TEACHER_ROLE)) {
                isAdminRole = true;
                break;
            } else  if (grantedAuthority.getAuthority().equals(STUDENT_ROLE)) {
                isCustomerRole = true;
                break;
            }
        }
        if (isAdminRole) {
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin");
        } else if (isCustomerRole) {
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/customer");
        } else {
            throw new IllegalStateException();
        }
    }
}
