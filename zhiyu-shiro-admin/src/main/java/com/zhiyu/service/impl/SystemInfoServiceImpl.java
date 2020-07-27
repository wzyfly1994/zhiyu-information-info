package com.zhiyu.service.impl;

import com.zhiyu.entity.pojo.SystemFilterChain;
import com.zhiyu.repository.SystemFilterChainRepository;
import com.zhiyu.service.SystemInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wengzhiyu
 * @date 2020/7/27
 */
@Service
@Slf4j
public class SystemInfoServiceImpl implements SystemInfoService {
    @Resource
    private SystemFilterChainRepository systemFilterChainRepository;

    @Override
    public String intiPermission() {
        Map<String, String> permissionMap = initPermissionMap();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : permissionMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }

    @Override
    public Map<String, String> initPermissionMap() {
        try {
            List<SystemFilterChain> shiroFilterChains = systemFilterChainRepository.findAll();
            Map<String, String> shiroFilterChainMap = new LinkedHashMap<>(shiroFilterChains.size());
            for (SystemFilterChain shiroFilterChain : shiroFilterChains) {
                shiroFilterChainMap.put(shiroFilterChain.getKey(), shiroFilterChain.getValue());
            }
            shiroFilterChainMap.put("/**", "authc");
            return shiroFilterChainMap;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>(0);
        }

    }
}
