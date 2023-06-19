package com.yq.dao.impl;

import com.yq.dao.Buyer;
import org.apache.log4j.Logger;

public class IntermediaryImpl implements Buyer {
    Logger logger = Logger.getLogger(this.getClass());
    private Buyer buyer;

    public IntermediaryImpl(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String havealook() {
        before();
        String feedback = buyer.havealook();
        after();
        return "看房记录：买家反馈“" + feedback + "”";
    }

    public void before() {
        logger.debug("前期准备");
        logger.debug("查找房源");
        logger.debug("和卖家沟通时间");
    }

    public void after() {
        logger.debug("后期跟踪");
        logger.debug("和买家沟通意见");
    }
}
