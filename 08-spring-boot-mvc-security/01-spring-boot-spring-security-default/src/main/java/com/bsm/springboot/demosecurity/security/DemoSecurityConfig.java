package com.bsm.springboot.demosecurity.security;

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

    // Import users & roles from DB
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    } 

   //filter handling method
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated() // everything else needs login
            )
            .exceptionHandling(auth -> auth
                            .accessDeniedPage("/access-denied")
            )
            .formLogin(form -> form
                .loginPage("/showMyLoginPage")    // your custom login page endpoint
                .loginProcessingUrl("/authenticateTheUser") // where login form POSTs credentials
                .failureUrl("/showMyLoginPage?error=true") // on login failure
                .permitAll()
            )
            .logout(logout -> logout.permitAll());
        return http.build();
    }
    /*
    // In-memory storing of users & roles.
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
    }  */

    /*
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
    }  */

}
