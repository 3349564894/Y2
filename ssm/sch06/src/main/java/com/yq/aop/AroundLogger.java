package com.yq.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

public class AroundLogger {
    private static final Logger logger = Logger.getLogger(AroundLogger.class);

    /**
     * 定义一个共享的切入点
     */
    @Pointcut(value = "execution(com.yq.service.* *(..))")
    public void pinit() {

    }

    /**
     * 使用注解方式使用增强
     */
    @Aspect
    public static class UserServiceLogger {
        private static final Logger log = Logger.getLogger(UserServiceLogger.class);

        /**
         * 前置增强
         */
        @Before(value = "pinit()")
        public void before(JoinPoint jp) {
            log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法,方法入参:" + Arrays.toString(jp.getArgs()));
        }

        /**
         * 后置增强
         *
         * @param jp
         * @param result
         */
        @AfterReturning(pointcut = "pinit()", returning = "result")
        public void after(JoinPoint jp, Object result) {
            log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法.方法返回值:" + result);
        }

        @Around(value = "pinit()")
        public Object afterLogger(ProceedingJoinPoint jp) throws Throwable {
            System.out.println("around");
            logger.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法。方法入参:" + Arrays.toString(jp.getArgs()));
            try {
                Object result = jp.proceed();
                logger.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法。方法返回值:" + result);
                return result;
            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                logger.info(jp.getSignature().getName() + "方法结束执行.");
            }
            return null;
        }
    }
}