package com.yq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 用户登录
     *
     * @param usrName
     * @param usrPassword
     * @return
     */
    @Select("select * from sys_user where usr_name = #{usrName} and usr_password = #{usrPassword};")
    User login(@Param("usrName") String usrName, @Param("usrPassword") String usrPassword);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Insert("insert into sys_user(usr_name,usr_password,usr_role_id,usr_flag)\n" +
            "\tvalues(#{usrId},#{usrName},#{usrRoleId},#{usrFlag})")
    Integer addUser(User user);

    /**
     * 删除用户
     *
     * @param usrId
     * @return
     */
    @Delete("delete from sys_user where usr_id = #{usrId}")
    void remove(Long usrId);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Update("update sys_user set \n" +
            "\tusr_name = #{usrName},\n" +
            "\tusr_password = #{usrPassword},\n" +
            "\tusr_role_id = #{usrRoleId},\n" +
            "\tusr_flag = #{usrFlag}")
    User updateUser(User user);

    /**
     * 获取用户信息
     *
     * @param usrId
     * @return
     */
    @Select("select * from sys_user where usr_id = #{usrId};")
    User getUser(Long usrId);

    /**
     * 查询全部用户
     *
     * @return
     */
    @Select("select * from sys_user;")
    List<User> findAllUsers();
}
