package com.yq.service.impl;

import com.yq.entity.User;
import com.yq.repository.UserRepository;
import com.yq.service.UserService;
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
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public Page<User> findPageByMap(Map param, Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<User> findPageByMap(Map param, Pageable pageable) {
//         return userRepository.findAll(new Specification<User>() {
//             @Override
//             public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                 List<Predicate> predicateList = new ArrayList<>();
//                 if (param.get("usrName") != null) {
//                     predicateList.add(criteriaBuilder.like(root.get("usrName"), "%" + param.get("usrName") + "%"));
//                 }
//                 if (param.get("roleId") != null) {
//                     predicateList.add(criteriaBuilder.equal(root.get("usrRoleId"), param.get("roleId")));
//                 }
//                 return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
//             }
//
//         }, pageable);
//    }
}
