package com.example.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.serverService.TplUserService;

@Component
public class AccountRealm extends AuthorizingRealm{
	@Reference
	TplUserService userService;
    

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        AccountProfile profile = userService.login(usernamePasswordToken.getUsername(), 
        		String.valueOf(usernamePasswordToken.getPassword()));
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
        		profile, token.getCredentials(), getName());
        return info;
    }
}
