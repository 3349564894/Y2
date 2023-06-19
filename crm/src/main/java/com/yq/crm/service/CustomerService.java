package com.yq.crm.service;

import com.yq.crm.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    public List<Customer> finNameAndRegion(@Param("name") String name, @Param("region") String region, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    Customer findCustomer(String custNo);

    Integer update(Customer customer);

    public int count(String name, String region);

    Integer delete1(String custNo);

    Integer delete2(String custNo);

    Integer delete3(String custNo);

    Integer delete4(String custNo);

    Integer delete5(String custNo);
}
