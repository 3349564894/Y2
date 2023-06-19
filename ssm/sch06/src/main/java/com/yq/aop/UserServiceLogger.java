package com.yq.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class UserServiceLogger {
    private static Logger logger = Logger.getLogger(UserServiceLogger.class);

    /**
     * 前置增强代码
     */
    public void before(JoinPoint jp) {
        logger.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法.方法入参:" + Arrays.toString(jp.getArgs()));
    }

    /**
     * 后置增强代码
     *
     * @param jp
     * @param result
     */
    public void afterReturning(JoinPoint jp, Object result) {
        logger.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法.方法返回值:" + result);
    }
}
