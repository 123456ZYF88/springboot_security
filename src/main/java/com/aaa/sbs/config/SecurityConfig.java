package com.aaa.sbs.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/2/14 10:33
 */
/*
@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //实例化 BCryptPasswordEnder
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //使用加密类生成加密密码
        String password = bCryptPasswordEncoder.encode("tiger");
        log.info("加密后的密码"+password);
        boolean matchesPassword = bCryptPasswordEncoder.matches("tiger",password);

        log.info("密码是否正确"+matchesPassword);
        //等于吧用户名密码直接配置 。使用时加载到内存中
        //withUser配置 用户名 scott 密码 tiger
        auth.inMemoryAuthentication().withUser("scott").password(password).roles("guanliyuan");

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
*/
