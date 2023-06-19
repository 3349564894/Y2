package com.yq.dao;

import com.yq.dao.impl.NewsDaoMySqlImpl;
import com.yq.dao.impl.NewsDaoOracleImpl;
import com.yq.dao.impl.NewsDaoRedisImpl;

public class SimpleDaoFactory {
    public static NewsDao getInstance(String key) {
        switch (key) {
            case "mysql":
                return new NewsDaoMySqlImpl();
            case "oracle":
                return new NewsDaoOracleImpl();
            case "redis":
                return new NewsDaoRedisImpl();
            default:
                throw new RuntimeException("无效的数据库类型" + key);
        }
//        return new NewsDaoImpl();
    }
}