package com.yq.crm.mapper;

import com.yq.crm.entity.Chance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanMapper {
    // 按条件插叙
    public List<Chance> findAll(@Param("chcCustName") String chcCustName, @Param("chcLinkman") String chcLinkman, @Param("chcTitle") String chcTitle, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    // 添加信息
    public int insert(Chance chance);

    public int count(@Param("chcCustName") String chcCustName, @Param("chcLinkman") String chcLinkman, @Param("chcTitle") String chcTitle);
}
