package com.yq.crm.mapper;

import com.yq.crm.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {
    public List<Dict> finIdAndValue(@Param("id") Integer id, @Param("value") String value, @Param("current") Integer current, @Param("pageSize") Integer pageSize);

    public int count(@Param("id") Integer id, @Param("value") String value);

    public int delDict(@Param("id") int id);

    public int updDict(Dict dict);

    public int allDict(Dict dict);

    public Dict finId(@Param("id") Integer id);
}
