package com.yq.mapper;

import com.yq.pojo.User;
import org.apache.ibatis.annotations.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import java.util.List;

public interface UserMapper {

    @Insert("insert into sys_user(usr_name,usr_password,usr_role_id,usr_flag) values(#{usr_name},#{usr_password},#{usr_role_id},#{usr_flag})")
    void insert(User user);

    @Delete("delete \n" +
            "         from\n" +
            "             sys_user\n" +
            "         where\n" +
            "             usr_id = #{usrId}")
    void delete(Long usrId);

    @Update("update\n" +
            "             sys_user\n" +
            "         set\n" +
            "             `usr_password` = #{usrPassword}\n" +
            "         where\n" +
            "             usr_id = #{usrId}")
    void update(@Param("usrId") Long usrId, @Param("usrPassword") String usrPassword);

    @Select("select\n" +
            "             usr_id,usr_name,usr_password,usr_role_id,usr_flag\n" +
            "     from\n" +
            "         sys_user\n" +
            "     where\n" +
            "         usr_id = #{usrId}")
    @Results({
            @Result(column = "usr_id", property = "usr_id"),
            @Result(column = "usr_id", property = "usr_name"),
            @Result(column = "usr_id", property = "usr_password"),
            @Result(column = "usr_id", property = "usr_role_id"),
            @Result(column = "usr_id", property = "usr_flag")
    })
    User find(Long usrId);

    @Select("select\n" +
            "             usr_id,usr_name,usr_password,usr_role_id,usr_flag\n" +
            "     from\n" +
            "         sys_user")
    @Results({
            @Result(column = "usr_id", property = "usr_id"),
            @Result(column = "usr_id", property = "usr_name"),
            @Result(column = "usr_id", property = "usr_password"),
            @Result(column = "usr_id", property = "usr_role_id"),
            @Result(column = "usr_id", property = "usr_flag")
    })
    List<User> findAll();
}
