package com.yq.repository;

import com.yq.entity.Role;
import com.yq.entity.User;
import com.yq.vo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByRoleId(Integer roleId);
}
