package com.jungle.springboot.security.support.security;

import com.jungle.springboot.security.entity.po.SystemPermission;
import com.jungle.springboot.security.entity.po.SystemUser;
import com.jungle.springboot.security.service.SystemPermissionService;
import com.jungle.springboot.security.service.SystemUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jungle
 * @version V1.0
 * @date 2019/6/6
 * 描述：定制Realm
 * copyright © 2019- .com
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    /**
     * 日志。
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("USER");
        String username = principalCollection.getPrimaryPrincipal().toString();
        SystemUser systemUser = systemUserService.loadUserByUsername(username);
        List<SystemPermission> permissionList = permissionService.listUserPermission(systemUser.getId());
        List<String> permissionStrings = permissionList.stream().map(SystemPermission::getCode).collect(Collectors.toList());
        info.addStringPermissions(permissionStrings);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        LOGGER.info("[Shiro][获取认证信息][username=>{}]", username);
        SystemUser systemUser = systemUserService.loadUserByUsername(username);
        if (systemUser != null) {
            return new SimpleAuthenticationInfo(username, systemUser.getPassword(), getName());
        }
        throw new UnknownAccountException("用户名或者密码错误");
    }
}
