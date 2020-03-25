package com.zlx.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class shiroConfig {

    /**
     * shiro三大对象
     * Subject
     * SecurityManager
     * Realm
     */


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager getDefaultSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultSecurityManager);
        /**
         * shiro过滤器
         *
         * anon 无需认证即可访问
         * authc 需要认证才可访问
         * user 使用rememberMe的功能可直接访问
         * perms 需要特定权限才能访问
         * role 需要特定的角色才能访问
         *
         */

        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/toLogin","anon");
        filterMap.put("/user/*","anon");
        filterMap.put("/h1","authc");
        filterMap.put("/h2","anon");
        filterMap.put("/h3","anon");
        filterMap.put("/login","anon");
        filterMap.put("/success","authc");
//        filterMap.put("/p1","perms[user:query]");

//        filterMap.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager getDefaultSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(getRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm getRealm(){
        MyRealm myRealm = new MyRealm();

        return myRealm;
    }
}
