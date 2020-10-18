package com.yinghan.coupon.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Rate Limiter</h1>
 */
@Slf4j
@Component
public class RateLimiteFilter extends AbstractPreFilter {

    RateLimiter rateLimiter = RateLimiter.create(20);

    @Override
    protected Object customRun() {
        HttpServletRequest request = context.getRequest();
        String ip = getUserIP(request);
        if (rateLimiter.tryAcquire()) {
            log.info(">>Get rate limiter permit token success");
            return success();
        } else {
            log.error(">>Rate limit to {}", request.getRequestURI());
            return fail(HttpStatus.FORBIDDEN, "error: request too fast!");
        }

    }

    private String getUserIP(HttpServletRequest request) {
        String ip = "";
        if (request != null) {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
                ip = request.getRemoteAddr();
            }
        }

        return ip;
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 2;
    }
}
