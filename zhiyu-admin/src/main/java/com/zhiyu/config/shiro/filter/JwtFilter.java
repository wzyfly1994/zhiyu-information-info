package com.zhiyu.config.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;
import java.util.Set;

/**
 * @author wengzhiyu
 * @date 2020/01/09
 */
public class JwtFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        //校验权限
        Subject subject = SecurityUtils.getSubject();
        String[] rolesArray = (String[]) o;
        System.out.println("rolesArray======" + Arrays.toString(rolesArray));
        subject.isPermitted("aa");
        Set<String> roles = CollectionUtils.asSet(rolesArray);
        //subject.hasRole("");
        return false;
    }
}
