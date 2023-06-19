package com.yq.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class ErrorLogger {
    private static final Logger logger = Logger.getLogger(ErrorLogger.class);

    public void afterThrowing(JoinPoint jp, RuntimeException e) {
        logger.info(jp.getSignature().getName() + "方法发生异常" + e);
    }
}
