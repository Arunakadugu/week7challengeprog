package me.afua.thymeleafsecdemo.security;

import me.afua.thymeleafsecdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                //I have a custom login form, but why can't I see my CSS?

                .antMatchers("/css/**","/js/**","/img/**","/h2-console/**","/register","/","/fonts/**").permitAll()
                .antMatchers("/").access("hasAuthority('USER') or hasAuthority('ADMIN')"  )
                .antMatchers("/admin","/pagethree").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll().permitAll();
//        .and()
//        .httpBasic();


    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("DaveWolf").password("beastmaster").authorities("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("password").authorities("USER");
        auth.userDetailsService(userDetailsServiceBean());
    }
}
