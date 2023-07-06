package com.yq.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yq.crm.entity.Right;
import com.yq.crm.entity.Role;
import com.yq.crm.mapper.RoleMapper;
import com.yq.crm.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @date 2023/7/5
 * @Author yq
 * @Version 1.0
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRoles() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id","rf_role_id");
        return roleMapper.selectList(wrapper);
    }

    @Override
    public List<Right> findRightByRole(Role role) {
        return roleMapper.findAllByRole(role);
    }

    @Override
    public List<Right> findAllRights() {
        return null;
    }
}