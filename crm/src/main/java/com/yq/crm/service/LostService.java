package com.yq.crm.service;

import com.yq.crm.entity.Lost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LostService {
    public List<Lost> finNameAndName(@Param("name") String name, @Param("name1") String name1, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    public int count(@Param("name") String name, @Param("name1") String name1);

    public Lost finId(@Param("id") Integer id);

    Integer update(Lost lost);
}
