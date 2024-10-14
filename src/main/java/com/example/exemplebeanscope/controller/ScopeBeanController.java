package com.example.exemplebeanscope.controller;

import com.example.exemplebeanscope.bean.PrototypeBean;
import com.example.exemplebeanscope.bean.RequestScopeBean;
import com.example.exemplebeanscope.bean.SessionScopeBean;
import com.example.exemplebeanscope.bean.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
public class ScopeBeanController {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;
    private final RequestScopeBean requestScopeBean;
    private final SessionScopeBean sessionScopeBean;


    public ScopeBeanController(SingletonBean singletonBean, RequestScopeBean requestScopeBean, SessionScopeBean sessionScopeBean, PrototypeBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.requestScopeBean = requestScopeBean;
        this.sessionScopeBean = sessionScopeBean;
        this.prototypeBean = prototypeBean;
    }

    @GetMapping("/singelton")
    public long getSingeletonScopeBeanId() {
        return singletonBean.getInstanceId();
    }

    @GetMapping("/prototype")
    public long getPrototypeScopeBeanId() {
        return prototypeBean.getInstanceId();
    }

    //A new bean instance is created for each HTTP request and is destroyed when the request completes.
    @GetMapping("/request")
    public long getRequestScopeBeanId() {
        return requestScopeBean.getInstanceId();
    }

    // A new bean instance is created for each HTTP session and is shared across multiple requests within that session.
    // The bean is destroyed when the session ends.
    @GetMapping("/session")
    public long getSessionScopeBeanId() {
        return sessionScopeBean.getInstanceId();
    }
}
