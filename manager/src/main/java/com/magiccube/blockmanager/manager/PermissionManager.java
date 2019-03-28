package com.magiccube.blockmanager.manager;

import com.magiccube.blockmanager.bean.PermissionData;
import com.magiccube.blockmanager.model.Permission;
import com.magiccube.blockmanager.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionManager {
    @Resource
    private PermissionRepository permissionRepository;
    @Resource
    private MemberManager memberManager;

    /**
     * 查询某个联盟内的所有权限
     *
     * @param memberName
     *         memberName
     * @return PermissionData
     */
    public PermissionData findGroupPermission(String memberName) {
        PermissionData permissionData = new PermissionData();
        String groupId = memberManager.findGroupId(memberName);
        permissionData.setPermissions(findPermission(groupId));
        permissionData.setCode(0);
        return permissionData;
    }

    private List<Permission> findPermission(String groupId) {
        return permissionRepository.findByGroupId(groupId);
    }
}
