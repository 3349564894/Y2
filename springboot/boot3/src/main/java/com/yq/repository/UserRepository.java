package com.yq.repository;

import com.yq.entity.Role;
import com.yq.entity.User;
import com.yq.vo.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u.usrId as usrId, u.usrName as usrName, u.usrPassword as usrpassword, u.role.roleId as usrRoleId, u.usrFlag as usrFlag, r.roleName as roleName from User u, Role r where u.role.roleId=r.roleId and u.usrId=?1")
    UserInfo getUserInfo(Integer usrId);

    User findByUsrId(Integer usrId);
}
