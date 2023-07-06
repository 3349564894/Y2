package com.yq.crm.service.impl;

import com.yq.crm.entity.Dict;
import com.yq.crm.mapper.DictMapper;
import com.yq.crm.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Resource
    private DictMapper dictMapper;

    @Override
    public List<Dict> finIdAndValue(Integer id, String value, Integer current, Integer pageSize) {
        return dictMapper.finIdAndValue(id, value, current, pageSize);

    }


    @Override
    public int count(Integer id, String value) {
        return dictMapper.count(id, value);
    }

    @Override
    public int delDict(int id) {
        return dictMapper.delDict(id);
    }

    @Override
    public int updDict(Dict dict) {
        return dictMapper.updDict(dict);
    }

    @Override
    public int allDict(Dict dict) {
        return dictMapper.allDict(dict);
    }

    @Override
    public Dict finId(Integer id) {
        return dictMapper.finId(id);
    }
}
