package com.yede.security.browser;

import com.yede.security.browser.authentication.SecurityAuthenticationFailureHandler;
import com.yede.security.browser.authentication.SecurityAuthenticationSuccessHandler;
import com.yede.security.core.properties.SecurityProperties;
import com.yede.security.core.validate.code.image.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(securityAuthenticationFailureHandler);
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin().loginPage("/authentication/require").loginProcessingUrl("/authentication/form")
                .successHandler(securityAuthenticationSuccessHandler).failureHandler(securityAuthenticationFailureHandler).and()
                .authorizeRequests().antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(), "/imageCode").permitAll()
                .anyRequest()
                .authenticated().and().csrf().disable();

    }
}
