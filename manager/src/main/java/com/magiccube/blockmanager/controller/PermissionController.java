package com.magiccube.blockmanager.controller;

import com.magiccube.blockmanager.bean.PermissionData;
import com.magiccube.blockmanager.manager.PermissionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("permission")
public class PermissionController {
    @Resource
    private PermissionManager permissionManager;

    /**
     * 查询某个联盟链的权限信息
     *
     * @param name
     *         member的名字
     * @return 权限集合
     */
    @GetMapping
    public PermissionData findGroupPermission(String name) {
        return permissionManager.findGroupPermission(name);
    }

    /**
     * 添加权限信息，由表的owner来给其他member设置权限
     * @return 权限信息
     */
    //@PostMapping
    //public PermissionData addPermission(String publicKey, ) {
    //
    //}
}
