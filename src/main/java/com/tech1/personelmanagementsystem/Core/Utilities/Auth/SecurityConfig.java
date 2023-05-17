
package com.tech1.personelmanagementsystem.Core.Utilities.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER","ADMIN");*/
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST,"/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/employees/get").authenticated()
                        .requestMatchers(HttpMethod.GET,"/api/employees/getall").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/employees/add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/update").hasRole("ADMIN"))
                .csrf().disable()
                .formLogin().disable()
                .rememberMe(httpSecurityRememberMeConfigurer -> httpSecurityRememberMeConfigurer.tokenValiditySeconds(3600));
        return http.build();
    }
}