package com.zhiyu.service.impl;

import com.zhiyu.common.exception.BusinessException;
import com.zhiyu.common.shiro.credentials.CustomCredentialsMatcher;
import com.zhiyu.config.constant.Constants;
import com.zhiyu.repository.SystemUserRepository;
import com.zhiyu.entity.pojo.SystemRole;
import com.zhiyu.entity.pojo.SystemUser;
import com.zhiyu.entity.dto.SystemUserDto;
import com.zhiyu.entity.vo.SystemUserVo;
import com.zhiyu.service.AboutUserService;
import com.zhiyu.utils.JwtUtil;
import com.zhiyu.utils.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author wengzhiyu
 * @date 2020/01/08
 */
@Service
public class AboutUserServiceImpl implements AboutUserService {

    @Resource
    SystemUserRepository systemUserRepository;


    @Override
    public ResponseData userLogin(SystemUserDto systemUserDto) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(systemUserDto.getAccount(),
                    CustomCredentialsMatcher.encrypt(systemUserDto.getPassword(), systemUserDto.getAccount()));
            subject.login(token);
            //生成token
            Map<String, Object> objectMap = new HashMap<>(8);
            objectMap.put("account", systemUserDto.getAccount());
            objectMap.put("timestamp", System.currentTimeMillis());
            String jwtToken = JwtUtil.getToken(objectMap);
            //session会话
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(Constants.LOGIN_TOKEN + systemUserDto.getAccount(), jwtToken);
            SystemUserVo vo = new SystemUserVo();
            vo.setToken(jwtToken);
            return ResponseData.success(vo);
        } catch (Exception e) {
            throw new BusinessException("登录失败：" + e.getMessage());
        }
    }

    @Override
    public ResponseData signIn(SystemUserDto systemUserDto) {
        String account = systemUserDto.getAccount();
        String phone = systemUserDto.getPhone();
        if (StringUtils.isBlank(phone)) {
            throw new BusinessException("手机号不能为空");
        }
        Optional<SystemUser> optionalSystemUser = systemUserRepository.findByAccountOrPhone(account, phone);
        if (optionalSystemUser.isPresent()) {
            throw new BusinessException("账号或手机号已存在");
        }
        String password = systemUserDto.getPassword();
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(systemUserDto, systemUser);
        systemUser.setPassWord(CustomCredentialsMatcher.encrypt(password, account));
        systemUserRepository.save(systemUser);
        return ResponseData.success();
    }

    @Override
    public SystemRole queryUserRole(SystemUser user) {
        //userRoleRepository.fin
        return null;
    }
}
