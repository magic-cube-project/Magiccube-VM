package com.magiccube.blockchain.common;

/**
 * 对表的权限
 */
public interface PermissionType {
    /**
     * 表的创建者
     */
    byte OWNER = 1;
    /**
     * 所有权限
     */
    byte ALL = 2;
    byte ADD = 3;
    byte UPDATE = 4;
    byte DELETE = 5;
    /**
     * 不可见
     */
    byte NONE = -1;
}
