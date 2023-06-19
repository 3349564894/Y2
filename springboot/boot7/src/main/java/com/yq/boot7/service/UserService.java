package com.yq.boot7.service;

import com.yq.boot7.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User login(String usrName,String usrPassword);
    void addUser(User user);
    void del(Long usrId);
    User findByUsrId(Long usrId);
    Page<User> findUsers(String usrName, Long roleId, Pageable pageable);
}
