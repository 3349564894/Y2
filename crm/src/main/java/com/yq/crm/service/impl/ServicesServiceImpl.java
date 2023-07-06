package com.yq.crm.service.impl;

import com.yq.crm.entity.Services;
import com.yq.crm.mapper.ServiceMapper;
import com.yq.crm.service.ServicesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Resource
    private ServiceMapper serviceMapper;


    @Override
    public List<Services> finAll(String svr_title, String svr_cust_name, String svr_type, Integer current, Integer pageSize) {
        return serviceMapper.finAll(svr_title, svr_cust_name, svr_type, current, pageSize);
    }

    @Override
    public int count(String svr_title, String svr_cust_name, String svr_type) {
        return serviceMapper.count(svr_title, svr_cust_name, svr_type);
    }

    @Override
    public Services findId(Integer id) {
        return serviceMapper.findId(id);
    }

    @Override
    public int updaService(Services services) {
        return serviceMapper.updaService(services);
    }

    @Override
    public int addService(Services services) {
        return serviceMapper.addService(services);
    }

    @Override
    public int delServices(int id) {
        return serviceMapper.delServices(id);
    }

    @Override
    public int updServiceTo(String id, String dueId, String dueTo) {
        return serviceMapper.updServiceTo(id, dueId, dueTo);
    }
}
