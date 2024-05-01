package com.tech552.springbootactuatordemo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * A custom web security configuration to secure the endpoints.
 */
@Configuration
public class CustomWebConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll() // all users
               .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN"); // only users with role ADMIN
       http.csrf().and().httpBasic();

    }
}
