package com.yq.dao;

import com.yq.dao.impl.IntermediaryMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;

public class IntermediaryCglibProxyFactory {
    private static IntermediaryMethodInterceptor callback = new IntermediaryMethodInterceptor();

    public static <T> T create(Class<T> target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(callback);
        enhancer.setSuperclass(target);
        return (T) enhancer.create();
    }
}
