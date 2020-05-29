package com.zhiyu.common.shiro.filter;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author wengzhiyu
 * @date 2020/01/09
 */
public class RoleAutoFilter extends AuthorizationFilter {

    /**
     * 返回为false才会执行onAccessDenied
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        //校验权限
//        Subject subject = SecurityUtils.getSubject();
//        String[] rolesArray = (String[]) o;
//        System.out.println("rolesArray======" + Arrays.toString(rolesArray));
//        subject.isPermitted("aa");
//        Set<String> roles = CollectionUtils.asSet(rolesArray);
//        subject.hasRole("");
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        return true;
    }

}
