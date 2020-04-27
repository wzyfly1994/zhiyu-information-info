package com.zhiyu.controller;

import cn.hutool.json.JSONObject;
import com.zhiyu.config.constant.Constants;
import com.zhiyu.config.shiro.credentials.CustomCredentialsMatcher;
import com.zhiyu.dao.system.SystemUserRepository;
import com.zhiyu.entity.system.SystemUser;
import com.zhiyu.util.JwtUtil;
import com.zhiyu.util.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * @author wengzhiyu
 * @date 2020/1/06
 */
@RestController
@RequestMapping("system")
public class SystemController {

    @Resource
    SystemUserRepository systemUserRepository;


    @GetMapping("welcome")
    public String test() {
        return "welcome";
    }

    @GetMapping("loginError")
    public ResponseData message() {
        return ResponseData.error("访问失败，用户未授权");
    }

    @PostMapping("login")
    public ResponseData login(String account, String password) {
        if (StringUtils.isBlank(account)) {
            ResponseData.error("账号为空");
        }
        if (StringUtils.isBlank(password)) {
            ResponseData.error("密码为空");
        }
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, CustomCredentialsMatcher.encrypt(password, account));
            subject.login(token);
            SystemUser systemUser = new SystemUser();
            systemUser.setAccount(account);
            Optional<SystemUser> userOptional = systemUserRepository.findOne(Example.of(systemUser));
            SystemUser user = userOptional.orElse(null);
            if (user != null) {
                //生成token
                Map<String, Object> objectMap = new HashMap<>(8);
                objectMap.put("account", account);
                objectMap.put("timestamp", System.currentTimeMillis());
                String jwtToken = JwtUtil.getToken(objectMap);
                //修改session会话
                Session session = SecurityUtils.getSubject().getSession();
                session.setAttribute(Constants.LOGIN_TOKEN, jwtToken);
                session.setAttribute(Constants.LOGIN_USER, user);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userName", user.getUserName());
                jsonObject.put(Constants.TOKEN, jwtToken);
                jsonObject.put("phone", user.getPhone());
                return ResponseData.success(jsonObject);
            }
        } catch (Exception e) {
            return ResponseData.error(e.getMessage());
        }
        return ResponseData.error("系统错误");
    }


    @GetMapping("httpTest")
    public void httpTest(HttpServletRequest request) {
        String seesionId = request.getSession().getId();
        System.out.println("seesionId++"+seesionId);
        System.out.println("action++"+request.getSession().getAttribute("wowo"));
    }

    @GetMapping("set")
    public void httpSet(HttpServletRequest request) {
        request.getSession().setAttribute("wowo","12345");
    }

}
