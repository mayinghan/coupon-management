package com.yinghan.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class LogFilter extends AbstractPostFilter{

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    protected Object customRun() {
        HttpServletRequest request = context.getRequest();
        Long startTime = (long)context.get("startTIme");
        String uri = request.getRequestURI();
        Long duration = System.currentTimeMillis() - startTime;

        log.info("uri: {} duration: {}", uri, duration);
        return success();
    }
}
