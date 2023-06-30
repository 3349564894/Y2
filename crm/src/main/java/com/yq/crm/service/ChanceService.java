package com.yq.crm.service;

import com.yq.crm.entity.Chance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChanceService {
    List<Chance> findByChcCustNameAndTitle(@Param("name") String name, @Param("title") String title, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    Chance findById(@Param("id") Long id);

    Integer updateChance(Chance chance);

    Integer addChance(Chance chance);

    Integer deleteChance(@Param("id") Long id);

    Integer count(@Param("name") String name, @Param("title") String title);
}
