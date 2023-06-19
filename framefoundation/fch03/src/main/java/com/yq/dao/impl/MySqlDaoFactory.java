package com.yq.dao.impl;

import com.yq.dao.AbstractFactory;
import com.yq.dao.NewsDao;

public class MySqlDaoFactory implements AbstractFactory {
    @Override
    public NewsDao getInstance() {
        return new NewsDaoMySqlImpl();
    }
}
