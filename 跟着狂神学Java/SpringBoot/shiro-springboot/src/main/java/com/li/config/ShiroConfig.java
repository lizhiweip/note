package com.li.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
@Bean
    //shiroFilterFactoryBean 第3步
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*  anno:无需认证就可以访问
            authc: 必须认证才能访问
            user: 必须拥有  记住我功能才能使用
            perms:拥有对某个资源的权限才能使访问
            role:拥有某个角色权限才能访问
         */

      //拦截
        Map<String ,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
    bean.setLoginUrl("/toLogin");

        return  bean;
    }


    //DefaultWebSecurityManager 第2步
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }
    //创建realm对象，需要自定义类  第1步
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
