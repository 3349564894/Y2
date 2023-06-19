package com.yq.repository;

import com.yq.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsrId(Integer usrId);

    User findByUsrNameAndUsrPassword(String usrName, String usrPassword);

    User findByUsrIdOrUsrName(Integer usrId, String usrName);

    List<User> findByUsrFlagOrderByUsrIdDesc(Integer usrFlag);

    @Query(value = "select * from sys_user  where usr_name like :usrName ", nativeQuery = true)
    List<User> findByUsrNameLike(@Param("usrName") String usrName);

    @Query(value = "select u from User u where u.usrName = ?1")
    Page<User> findPageByUsrName(String usrName, Pageable pageable);

}
