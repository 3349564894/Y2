package com.yq.crm.mapper;

import com.yq.crm.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    public List<Customer> finNameAndRegion(@Param("name") String name, @Param("region") String region, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    public int count(@Param("name") String name, @Param("region") String region);

    Customer findCustomer(String custNo);

    Integer update(Customer customer);

    Integer delete1(String custNo);

    Integer delete2(String custNo);

    Integer delete3(String custNo);

    Integer delete4(String custNo);

    Integer delete5(String custNo);

//    Integer add();
}
