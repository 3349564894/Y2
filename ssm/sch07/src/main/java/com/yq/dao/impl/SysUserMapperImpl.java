package com.yq.dao.impl;

import com.yq.dao.SysUserMapper;
import com.yq.entity.SysUser;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class SysUserMapperImpl extends SqlSessionDaoSupport implements SysUserMapper {

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<SysUser> findUser() {
        return this.getSqlSession().selectList("com.yq.dao.SysUserMapper.findUser");
    }

    @Override
    public Integer add(SysUser sysUser) {
        return this.getSqlSession().insert("", new SysUser());
    }
}
