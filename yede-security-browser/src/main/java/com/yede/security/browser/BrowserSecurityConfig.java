package com.yede.security.browser;

import com.yede.security.browser.authentication.SecurityAuthenticationFailureHandler;
import com.yede.security.browser.authentication.SecurityAuthenticationSuccessHandler;
import com.yede.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private  SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/authentication/require").loginProcessingUrl("/authentication/form")
                .successHandler(securityAuthenticationSuccessHandler).failureHandler(securityAuthenticationFailureHandler).and()
                .authorizeRequests().antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated().and().csrf().disable();

    }
}
