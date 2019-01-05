package com.mlj.tshop.common.constant;

/**
 * 2018/12/06：管理员常量
 *
 * @author mlj
 */
public interface ManagerConstant {

    /**
     * 用户类型
     */
    public static final String MANAGER ="manager";
    /**
     * ID长度
     */
    public static final Integer ID_LENGTH = 6;
    /**
     * 管理员可用
     */
    public static final Integer MANAGER_ENABLE = 1;
    /**
     * 管理员禁用
     */
    public static final Integer MANAGER_DISABLE = 0;
    /**
     * 系统管理员
     */
    public static final Integer MANAGER_SYSDBA = 1;
    /**
     * 普通管理员
     */
    public static final Integer MANAGER_GENERAL = 2;

}
