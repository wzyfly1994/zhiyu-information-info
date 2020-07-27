package com.zhiyu.service;

import java.util.Map;

/**
 * @author wengzhiyu
 * @date 2020/7/27
 */
public interface SystemInfoService {

    /**
     * 初始化框架权限资源配置
     *
     * @return
     */
    String intiPermission();


    /**
     * 过滤连MAP
     *
     * @return
     */
    Map<String, String> initPermissionMap();
}
