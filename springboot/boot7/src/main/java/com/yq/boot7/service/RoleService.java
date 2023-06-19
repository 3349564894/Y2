package com.yq.boot7.service;

import com.yq.boot7.entity.Role;
import com.yq.boot7.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface RoleService {
    List<Role> findRoles();
}
