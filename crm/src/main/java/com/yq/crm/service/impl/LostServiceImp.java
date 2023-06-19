package com.yq.crm.service.impl;

import com.yq.crm.entity.Lost;
import com.yq.crm.mapper.LostMapper;
import com.yq.crm.service.LostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LostServiceImp implements LostService {
    @Resource
    private LostMapper lostMapper;

    @Override
    public List<Lost> finNameAndName(String name, String name1, Integer current, Integer pageSize) {
        return lostMapper.finNameAndName(name, name1, current, pageSize);
    }

    @Override
    public int count(String name, String name1) {
        return lostMapper.count(name, name1);
    }

    @Override
    public Lost finId(Integer id) {
        return lostMapper.finId(id);
    }

    @Override
    public Integer update(Lost lost) {
        return lostMapper.update(lost);
    }

}
