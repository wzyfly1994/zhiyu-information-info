package com.zhiyu.service.impl;

import com.zhiyu.entity.dto.SystemRoleDto;
import com.zhiyu.entity.pojo.SystemPermission;
import com.zhiyu.entity.pojo.SystemRole;
import com.zhiyu.entity.pojo.SystemRolePermission;
import com.zhiyu.repository.SystemPermissionRepository;
import com.zhiyu.repository.SystemRolePermissionRepository;
import com.zhiyu.repository.SystemRoleRepository;
import com.zhiyu.service.SystemRoleService;
import com.zhiyu.utils.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wengzhiyu
 * @date 2020/9/15
 */
@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    private SystemRoleRepository systemRoleRepository;
    @Autowired
    private SystemRolePermissionRepository systemRolePermissionRepository;
    @Autowired
    private SystemPermissionRepository systemPermissionRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData addRole(SystemRoleDto systemRoleDto) {
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(systemRoleDto, systemRole);
        systemRole.setRoleValue(RandomStringUtils.randomAlphanumeric(32));
        SystemRole roleMode = systemRoleRepository.save(systemRole);
        //菜单列表
        List<Long> menuIdList = systemRoleDto.getMenuIdList();
        if (!CollectionUtils.isEmpty(menuIdList)) {
            for (Long menuId : menuIdList) {
                List<Long> permissionList = systemPermissionRepository.findAllByMenuId(menuId).stream().map(SystemPermission::getId).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(permissionList)) {
                    Long permissionId = permissionList.get(0);
                    SystemRolePermission systemRolePermission = new SystemRolePermission();
                    systemRolePermission.setRoleId(roleMode.getId());
                    systemRolePermission.setPermissionId(permissionId);
                    systemRolePermissionRepository.save(systemRolePermission);
                }
            }
        }
        return ResponseData.success();
    }
}
