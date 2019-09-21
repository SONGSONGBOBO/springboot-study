package com.bobo.shiro.bean;

import com.bobo.shiro.dao.UserRepository;
import com.bobo.shiro.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ShiroRealm
 * @Description TODO
 * @Author songbo
 * @Date 19-5-3 下午6:29
 **/
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserRepository userDao;

    /**
     * 获取用户角色和权限（暂不实现）
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登陆认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取界面中输入的用户名和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        //String password = (String) authenticationToken.getCredentials();
        log.info("认证登录：username is {}", username);

        // 通过用户名获取用户信息
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getUserPwd())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        /*if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定!");
        }*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
