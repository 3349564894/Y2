package com.yq.crm.service.impl;

import com.yq.crm.entity.Chance;
import com.yq.crm.mapper.PlanMapper;
import com.yq.crm.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanMapper planMapper;


    @Override
    public List<Chance> findAll(String chcCustName, String chcLinkman, String chcTitle, Integer current, Integer pageSize) {
        return planMapper.findAll(chcCustName, chcLinkman, chcTitle, current, pageSize);
    }

    @Override
    public int insert(Chance chance) {
        return planMapper.insert(chance);
    }

    @Override
    public int count(String chcCustName, String chcLinkman, String chcTitle) {
        return planMapper.count(chcCustName, chcLinkman, chcTitle);
    }
}
