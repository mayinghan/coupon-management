package com.yinghan.coupon.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

public abstract class AbstractGeneralFilter extends ZuulFilter {
    RequestContext context; // Pass info between filters. Stored in ThreadLocal of each request

    private static final String NEXT = "next";

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.getOrDefault(NEXT, true);
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() {
        context = RequestContext.getCurrentContext();
        return customRun();
    }

    protected abstract Object customRun();

    protected Object fail(HttpStatus code, String msg) {
        context.set(NEXT, false);
        context.setSendZuulResponse(false);
        context.getResponse().setContentType("text/html;charset=UTF-8");
        context.setResponseStatusCode(code.value());
        context.setResponseBody(String.format(
                "{\"reslt\": \"%s\"}", msg
        ));

        return null;
    }

    protected Object success() {
        context.set(NEXT, true);

        return null;
    }
}
