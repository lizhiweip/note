package com.li.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//AOP
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，但是功能页只有对应有权限的人才能访问
        //请求授权的规则
        //认证请求
        http.authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers("/level1/**").hasRole("vip1")
                                .antMatchers("/level2/**").hasRole("vip2")
                                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限默认会到登录页面，需要开启登录页面
        //定制登录页
        http.formLogin().loginPage("/toLogin");

        //防止网站工具：get，post
        http.csrf().disable();//关闭csrf功能，防止跨站攻击

        //注销，开启了注销功能
        http.logout().logoutUrl("/index");

        //开启记住我功能 默认保存两周，自定义前端参数
        http.rememberMe().rememberMeParameter("remember");


    }
    //认证，springboot 2.1.x可以直接使用
    //密码编码：PassWordEncoder
    //在spring security 5.0+ 中新增了很多加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //这些数据正常应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lizhiwei").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("lizhiwei2").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("lizhiwei3").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
