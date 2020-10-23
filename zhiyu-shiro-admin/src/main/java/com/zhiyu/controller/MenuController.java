package com.zhiyu.controller;

import com.zhiyu.repository.SystemMenuRepository;
import com.zhiyu.utils.ResponseData;
import com.zhiyu.utils.tree.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wengzhiyu
 * @date 2020/10/21
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "菜单模块")
public class MenuController {

    @Autowired
    private SystemMenuRepository systemMenuRepository;

    @GetMapping("/tree")
    @ApiOperation("菜单树")
    public ResponseData menuTree() {
        return ResponseData.success(TreeUtil.listToTree(0L, systemMenuRepository.findAllByOrderBySerialNumAsc()));
    }

    @GetMapping("/addTree")
    @ApiOperation("菜单树")
    public ResponseData addMenu() {
        return null;
    }


}
