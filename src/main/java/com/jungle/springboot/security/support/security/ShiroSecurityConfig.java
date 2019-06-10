package com.jungle.springboot.security.support.security;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jungle
 * @version V1.0
 * @date 2019/6/6
 * 描述：Shiro安全相关的配置
 * copyright © 2019- .com
 */
@Configuration
public class ShiroSecurityConfig {


    /**
     * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
     * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
     * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {

        return new LifecycleBeanPostProcessor();
    }

    /**
     * DefaultAdvisorAutoProxyCreator 是用来扫描上下文，寻找所有的Advistor（通知器），
     * 将这些Advistor应用到所有符合切入点的Bean中。而lifecycleBeanPostProcessor
     * 将Initializable和Destroyable的实现类统一在其内部自动分别调用了Initializable.init()和Destroyable.destroy()方法，从而达到管理shiro bean生命周期的目的。
     * 因此需要让DefaultAdvisorAutoProxyCreator依赖于lifecycleBeanPostProcessor。
     *
     * @return {@link DefaultAdvisorAutoProxyCreator}
     */
    @Bean(name = "defaultAdvisorAutoProxyCreator")
    @DependsOn("authorizationAttributeSourceAdvisor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setUsePrefix(true);
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    @Bean(name = "authorizationAttributeSourceAdvisor")
    @DependsOn("lifecycleBeanPostProcessor")
    @Autowired
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(86400000);
        return sessionManager;
    }

    /**
     * SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
     */
    @Bean(name = "securityManager")
    @Autowired
    public DefaultWebSecurityManager securityManager(CustomRealm customRealm, DefaultWebSessionManager sessionManager) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager);
        securityManager.setRealm(customRealm);

        return securityManager;
    }

    /**
     * ShiroFilterFactoryBean，是个factoryBean，为了生成ShiroFilter。
     * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/login");
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/403");

        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
        filterChainDefinitionManager.put("/static/**", "anon");
        filterChainDefinitionManager.put("/login", "anon");
        filterChainDefinitionManager.put("/logout", "logout");
        filterChainDefinitionManager.put("/error/**", "anon");
        filterChainDefinitionManager.put("/error", "anon");
        filterChainDefinitionManager.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

        return shiroFilterFactoryBean;
    }
}
