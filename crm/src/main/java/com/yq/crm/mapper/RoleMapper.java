package com.yq.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.crm.entity.Right;
import com.yq.crm.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findAll();
    List<Right> findAllByRole(Role role);
    List<Right> findAllRights();
}
