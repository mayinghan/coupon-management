package com.yinghan.coupon.filter;

import org.springframework.stereotype.Component;

/**
 * <h1>Get timestamp when the request comes in</h1>
 */
@Component
public class PreRequestFilter extends AbstractPreFilter{

    @Override
    protected Object customRun() {
        context.set("startTime", System.currentTimeMillis());

        return success();
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
