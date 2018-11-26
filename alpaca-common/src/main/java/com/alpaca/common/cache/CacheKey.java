package com.alpaca.common.cache;

/**
 * @Auther: song
 * @Date: 2018/11/7 11:16
 * @Description: 缓存标识前缀集合,常用在ConstantFactory类中
 * @Version:1.0.0
 */
public interface CacheKey {
    /**
     * 角色名称(多个)
     */
    String ROLES_NAME = "roles_name_";

    /**
     * 角色名称(单个)
     */
    String SINGLE_ROLE_NAME = "single_role_name_";

    /**
     * 角色英文名称
     */
    String SINGLE_ROLE_TIP = "single_role_tip_";

    /**
     * 部门名称
     */
    String DEPT_NAME = "org_name_";
}
