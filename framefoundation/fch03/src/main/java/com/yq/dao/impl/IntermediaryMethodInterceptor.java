package com.yq.dao.impl;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class IntermediaryMethodInterceptor implements MethodInterceptor {
    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object feedback = proxy.invokeSuper(obj, args);
        after();
        return "看房记录：买家反馈：" + feedback;
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
