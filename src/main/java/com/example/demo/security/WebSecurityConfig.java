package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String STUDENT_ROLE = "User";
    private static final String TEACHER_ROLE = "Admin";

    @Autowired
    private DataSource dataSource;

    @Autowired
    AuthenticationSuccessHandlerCustom authenticationSuccessHandlerCustom;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT userName, password, userRole FROM user WHERE userName=?")
                .authoritiesByUsernameQuery("SELECT u.userName, r.role FROM user_role ur " +
                        " INNER JOIN user u ON u.id = ur.user_id" +
                        " INNER JOIN role r ON r.id = ur.role_id" +
                        " WHERE u.userName=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/admin").hasAuthority(TEACHER_ROLE)
                .antMatchers("/customer").hasAuthority(STUDENT_ROLE)
                .and()
                .formLogin().permitAll()
                .successHandler(authenticationSuccessHandlerCustom)
                .and()
                .logout().permitAll();
    }
}
