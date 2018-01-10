package com.yede.security.browser;

import com.yede.security.browser.authentication.SecurityAuthenticationFailureHandler;
import com.yede.security.browser.authentication.SecurityAuthenticationSuccessHandler;
import com.yede.security.core.properties.SecurityProperties;
import com.yede.security.core.validate.code.ValidateCodeFilter;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService myUserDetailsService;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin().loginPage("/authentication/require").loginProcessingUrl("/authentication/form")
                .successHandler(securityAuthenticationSuccessHandler).failureHandler(securityAuthenticationFailureHandler)
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(myUserDetailsService).and()
                .authorizeRequests().antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(), "/imageCode", "/smsCode").permitAll()
                .anyRequest()
                .authenticated().and().csrf().disable();

    }
}
