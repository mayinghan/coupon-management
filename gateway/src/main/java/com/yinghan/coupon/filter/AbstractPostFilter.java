package com.yinghan.coupon.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public abstract class AbstractPostFilter extends AbstractGeneralFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }
}
