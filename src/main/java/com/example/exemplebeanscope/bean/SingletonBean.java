package com.example.exemplebeanscope.bean;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    private final long instanceId = System.nanoTime();

    public long getInstanceId() {
        return instanceId;
    }

}
