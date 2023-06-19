package com.yq.dao.impl;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IntermediaryInvocationHandler implements InvocationHandler {
    Logger logger = Logger.getLogger(this.getClass());

    private Object target;

    public static <T> T create(Object target) {
        IntermediaryInvocationHandler handler = new IntermediaryInvocationHandler();
        handler.setTarget(target);
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object feedback = method.invoke(target, args);
        after();
        return "看房记录，买家反馈：’" + feedback + "‘'";
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
