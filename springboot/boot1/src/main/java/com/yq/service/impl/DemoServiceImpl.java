package com.yq.service.impl;

import com.yq.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello() {
        return "hello world";
    }
}
