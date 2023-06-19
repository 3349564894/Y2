package com.yq.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class AfterLogger {
    private static final Logger logger = Logger.getLogger(AfterLogger.class);

    public void afterLogger(JoinPoint jp) {
        logger.info(jp.getSignature().getName() + "方法结束执行");
    }
}
