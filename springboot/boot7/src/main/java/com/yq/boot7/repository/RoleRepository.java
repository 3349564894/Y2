package com.yq.boot7.repository;


import com.yq.boot7.entity.Role;
import com.yq.boot7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
