package com.yq.dao.impl;

import com.yq.dao.Buyer;
import org.apache.log4j.Logger;

/**
 * 真实主题，买家业务
 */
public class RealBuyer implements Buyer {
    @Override
    public String havealook() {
        Logger logger = Logger.getLogger(this.getClass());
        logger.debug("实地的看一下");
        return "一些意见";
    }
}
