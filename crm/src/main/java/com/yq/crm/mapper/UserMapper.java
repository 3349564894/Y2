package com.yq.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;
import com.yq.crm.vo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据条件查询用户并分页
     *
     * @param usr_id
     * @param usr_name
     * @param pageable
     * @return
     */
    IPage<User> findUsers(@Param("usr_id") Long usr_id, @Param("usr_name") String usr_name, Pageable pageable);

    User findUser(@Param("usr_name") String usr_name, @Param("usr_password") String user_password);

    User findById(Long usr_id);

    List<String> findRoleName();

    User findByName(String usrName);

//    User findByUsrNameAndUsrPassword();

    int updateUser(User userInfo);

    int deleteUser(Long usrId);

    int addUser(User user);
}
