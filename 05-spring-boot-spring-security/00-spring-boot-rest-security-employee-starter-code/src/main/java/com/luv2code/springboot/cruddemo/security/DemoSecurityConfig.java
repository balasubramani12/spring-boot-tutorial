package com.luv2code.springboot.cruddemo.security;

import org.springframework.security.config.Customizer;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager theData = new JdbcUserDetailsManager(dataSource); 
        theData.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");                          
        theData.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return theData;
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                            .username("john")
                            .password("{noop}test123")
                            .roles("EMPLOYEE")
                            .build();
        UserDetails mary = User.builder()
                            .username("mary")
                            .password("{noop}test123")
                            .roles("EMPLOYEE", "MANAGER")
                            .build();
        UserDetails susan = User.builder()
                            .username("susan")
                            .password("{noop}test123")
                            .roles("EMPLOYEE", "MANAGER", "ADMIN")
                            .build(); 
        return new InMemoryUserDetailsManager(john, mary, susan);                           
    }
    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

        );

        // use HTTP Basic Auth
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF :: In general it is not req for stateless REST Api's that uses POST, PUT, DELETE, PATCH
        http.csrf(csrf ->csrf.disable());

        return http.build();
    }

}
