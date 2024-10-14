package com.example.exemplebeanscope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopeBean {
    private final long instanceId = System.nanoTime();

    public long getInstanceId() {
        return instanceId;
    }

}
