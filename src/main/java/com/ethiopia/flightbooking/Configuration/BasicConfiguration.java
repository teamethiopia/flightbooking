package com.ethiopia.flightbooking.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http


                .authorizeRequests().antMatchers("/flightbooking/airline/*").hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/flightbooking/airplane/*").hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/flightbooking/airport/*").hasRole("ADMIN")
                .antMatchers("/flightbooking/booking/*").permitAll().and()
                .formLogin().permitAll().and()
                .logout().permitAll().invalidateHttpSession(true).deleteCookies("JSESSIONID").and()
                 .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

}
