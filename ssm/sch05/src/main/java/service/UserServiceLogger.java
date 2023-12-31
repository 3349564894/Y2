package service;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class UserServiceLogger {
    private static final Logger logger = Logger.getLogger(UserServiceLogger.class);

    public void before(JoinPoint jp) {
        logger.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法。方法入参:" + Arrays.toString(jp.getArgs()));
    }

    public void afterReturning(JoinPoint jp, Object result) {
        logger.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法。方法返回值:" + result);
    }
}
