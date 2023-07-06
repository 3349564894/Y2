package com.yq.crm.service;

import com.yq.crm.entity.Right;
import com.yq.crm.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    List<Right> findRightByRole(Role role);
    List<Right> findAllRights();
}
