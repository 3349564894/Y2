package com.yq.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.crm.entity.Right;
import com.yq.crm.entity.Role;
import java.util.List;

interface RightMapper extends BaseMapper<Right> {
    /**
     * 根据角色查询条件
     * @param role
     * @return
     */
    List<Right> findRightsByRolesOrderByRightCode(Role role);
}