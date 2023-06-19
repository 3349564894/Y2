package com.yq.dao.sysuser;

import com.yq.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

@Alias("UserMapper")
public interface SysUserMapper {

    /**
     * 根据用户的真实姓名模糊查
     *
     * @param realName
     * @return
     */
    List<SysUser> getUserByRealName(@Param("realName") String realName);

    /**
     * 使用对象查询用户信息
     *
     * @param sysUser
     * @return
     */
    List<SysUser> getUserListByPojo(SysUser sysUser);

    /**
     * 使用map查询用户信息
     *
     * @param map
     * @return
     */
    List<SysUser> getUserLisetByMap(Map<String, Object> map);

    /**
     * 使用注解
     *
     * @param realName
     * @param roleId
     * @return
     */
    List<SysUser> getUserLisetByParams(@Param("rname") String realName, @Param("rid") int roleId);

    /**
     * 查询用户信息及角色、供货商
     *
     * @param sysUser
     * @return
     */
    List<SysUser> getUserListWithRoleName(SysUser sysUser);

    /**
     * 根据id查询用户、包含系统角色
     *
     * @param roleId
     * @return
     */
    List<SysUser> getUserListByRoleId(Integer roleId);

    /**
     * 根据id查询用户、包含系统角色、地址         示例21
     *
     * @param userId
     * @return
     */
    List<SysUser> getUserAndAddressesByUserId(Integer userId);
}