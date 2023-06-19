package com.yq.dao.impl;

import com.yq.dao.CalculatorDao;
import com.yq.dao.CalculatorDaoFactory;

public class ChenDaoFactory implements CalculatorDaoFactory {
    @Override
    public CalculatorDao getInstance() {
        return new Chen();
    }
}
