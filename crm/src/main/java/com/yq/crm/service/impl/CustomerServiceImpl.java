package com.yq.crm.service.impl;

import com.yq.crm.entity.Customer;
import com.yq.crm.service.CustomerService;
import com.yq.crm.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> finNameAndRegion(String name, String region, Integer current, Integer pageSize) {
        return customerMapper.finNameAndRegion(name, region, current, pageSize);
    }

    @Override
    public Customer findCustomer(String custNo) {
        return customerMapper.findCustomer(custNo);
    }

    @Override
    public Integer update(Customer customer) {
        return customerMapper.update(customer);
    }

    @Override
    public int count(String name, String region) {
        return customerMapper.count(name, region);
    }

    @Override
    public Integer delete1(String custNo) {
        return customerMapper.delete1(custNo);
    }

    @Override
    public Integer delete2(String custNo) {
        return customerMapper.delete2(custNo);
    }

    @Override
    public Integer delete3(String custNo) {
        return customerMapper.delete3(custNo);
    }

    @Override
    public Integer delete4(String custNo) {
        return customerMapper.delete4(custNo);
    }

    @Override
    public Integer delete5(String custNo) {
        return customerMapper.delete5(custNo);
    }
}
