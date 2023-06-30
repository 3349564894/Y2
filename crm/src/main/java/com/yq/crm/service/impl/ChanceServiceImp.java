package com.yq.crm.service.impl;

import com.yq.crm.entity.Chance;
import com.yq.crm.mapper.ChanceMapper;
import com.yq.crm.service.ChanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChanceServiceImp implements ChanceService {
    @Resource
    private ChanceMapper chanceMapper;

    @Override
    public List<Chance> findByChcCustNameAndTitle(String name, String title, Integer current, Integer pageSize) {
        return chanceMapper.findByChcCustNameAndTitle(name, title, current, pageSize);
    }

    @Override
    public Chance findById(Long id) {
        return chanceMapper.findById(id);
    }

    @Override
    public Integer updateChance(Chance chance) {
        return chanceMapper.updateChance(chance);
    }

    @Override
    public Integer addChance(Chance chance) {
        return chanceMapper.addChance(chance);
    }

    @Override
    public Integer deleteChance(Long id) {
        return chanceMapper.deleteChance(id);
    }

    @Override
    public Integer count(String name, String title) {
        return chanceMapper.count(name, title);
    }


}
