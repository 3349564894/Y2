package com.yq.boot7.service.impl;


import com.yq.boot7.entity.Role;
import com.yq.boot7.entity.User;
import com.yq.boot7.repository.UserRepository;
import com.yq.boot7.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Resource
    UserRepository repository;

    @Override
    public User login(String usrName, String usrPassword) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void del(Long usrId) {

    }

    @Override
    public User findByUsrId(Long usrId) {
        return null;
    }

    @Override
    public Page<User> findUsers(String usrName, Long roleId, Pageable pageable) {
        Specification<User> userSpecification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (usrName != null && !usrName.equals("")){
                    predicateList.add(criteriaBuilder.like(root.get("usrName"),"%"+usrName+"%"));
                }
                if (roleId != null && roleId.longValue() != 0){
                    Role role = new Role();
                    role.setRoleId(roleId);
                    predicateList.add(criteriaBuilder.equal(root.get("usr_role_id"),role));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return repository.findAll(userSpecification,pageable);
    }
}
