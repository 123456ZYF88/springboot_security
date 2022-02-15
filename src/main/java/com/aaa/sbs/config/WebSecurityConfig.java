package com.aaa.sbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/2/14 10:32
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置获取用户信息接口 配置加密方式
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义用户登录，注销 角色 /权限 授权配置 都在该方法配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置登录页面信息
        http.formLogin()//总体form方式
                .loginPage("/html/login.html") //配置登录页面路劲
                .loginProcessingUrl("/user/login") //登录页面中form 配置的请求地址
                .failureUrl("/html/login.html?error")//登录失败路劲配置
                .defaultSuccessUrl("/html/indexl.html").permitAll()//默认登录成功的
                .and().authorizeRequests()//逻辑所有的授权请求
                .antMatchers("/user/login","/","/css/**","/js/**").permitAll()
                //.antMatchers("/dept/queryAll").hasAuthority("dept:query")//设值拥有某一个权限或者角色，才可以访问指定路径
                //.antMatchers("/dept/queryAll").hasAnyAuthority("dept:query","dept:update1","dept:delete")//设值拥有多个中的某一个权限或者角色，才可以访问指定路径
                //.a("dept:query1","dept:dept:update1","dept:delete")

               // .antMatchers("/dept/queryById").hasRole("guanliyuan")//拥有管理角色访问该路径
             // .antMatchers("/dept/queryById").hasAnyRole("guanliyuan","dailishang")//设置拥有多个中某一个角色，才可以访问

               .antMatchers("/dept/add").hasIpAddress("192.168.220.1")//固定的ip才允许
                .anyRequest().authenticated()//除了上面配置的，其他请求都需要认证
                .and().csrf().disable();//关闭csrf概念 如果不关闭
        //配置未授权跳转页面
        http.exceptionHandling().accessDeniedPage("/html/unauthorized.html");
        //注销配置 如果使用默认 /logout 可以不用配置
        http.logout().logoutUrl("/logout")//用户请求注销 请求地址
                .logoutSuccessUrl("/html/login.html").permitAll();//注销成功跳转地址
    }
}
