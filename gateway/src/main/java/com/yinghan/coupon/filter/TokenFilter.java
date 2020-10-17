package com.yinghan.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  <h1>Verify token before request being handled</h1>
 */
@Component
@Slf4j
public class TokenFilter extends AbstractPreFilter {

    @Override
    protected Object customRun() {
        HttpServletRequest req = context.getRequest();
        log.info(String.format("%s request to %s", req.getMethod(), req.getRequestURI()));
        Object token = req.getParameter("token");
        if(token == null) {
            log.error("error: token is empty");
            return fail(HttpStatus.UNAUTHORIZED, "token is empty");
        }

        // TODO: validate token
        return success();
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 1;
    }
}
