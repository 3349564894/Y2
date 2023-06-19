package com.yq.dao.impl;

import com.yq.dao.CalculatorDao;
import com.yq.dao.CalculatorDaoFactory;

public class JianDaoFactory implements CalculatorDaoFactory {
    @Override
    public CalculatorDao getInstance() {
        return new Jian();
    }
}
