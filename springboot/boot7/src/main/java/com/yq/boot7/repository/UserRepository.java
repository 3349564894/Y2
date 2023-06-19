package com.yq.boot7.repository;


import com.yq.boot7.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    List<User> findByUsrNameAndUsrPassword(String usrName,String usrPassword);
}
