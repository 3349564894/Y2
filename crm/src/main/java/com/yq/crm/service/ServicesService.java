package com.yq.crm.service;

import com.yq.crm.entity.Services;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicesService {
    public List<Services> finAll(@Param("svr_title") String svr_title, @Param("svr_cust_name") String svr_cust_name, @Param("svr_type") String svr_type, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    public int count(@Param("svr_title") String svr_title, @Param("svr_cust_name") String svr_cust_name, @Param("svr_type") String svr_type);

    public Services findId(@Param("id") Integer id);

    public int updaService(Services services);

    public int addService(Services services);

    public int delServices(@Param("id") int id);

    public int updServiceTo(@Param("id") String id, @Param("dueId") String dueId, @Param("dueTo") String dueTo);
}
