package com.yq.service.impl;

import com.yq.entity.SysUser;
import com.yq.dao.SysUserMapper;
import com.yq.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Transactional(rollbackFor = {SQLException.class})
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource(name = "sysUserMapper")
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUser() {
        return sysUserMapper.findUser();
    }

    @Override
    public boolean add(SysUser sysUser) {
        boolean result = false;
        try {
            if (sysUserMapper.add(sysUser) == 1) {
                result = true;
                //模拟失败
//                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
