package com.yinghan.coupon.vo;

import com.yinghan.coupon.constant.ValidityPeriod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRuleVO {
    private Expiration expiration;
    private Discount discount;
    // rule of how many coupon could one user have
    private Integer numLimitation;
    private Usage usage;
    // rule of using multiple coupon together
    private String overlay;
    /**
     *  expiration rule
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Expiration {
        private Integer validityPeriodCode;
        private Integer duration;  // only works for SHIFT period
        private Long deadline;

        boolean validate() {
            return null != ValidityPeriod.of(validityPeriodCode) && duration > 0 && deadline > new Date().getTime();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Discount {
        private Integer quota;
        private Integer base; // only used by cashback_with_condition type.

        boolean validate() {
            return quota > 0 && base > 0;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usage {
        private String country;
        private String state;
        private String goodType;

        boolean validate() {
            return StringUtils.isNotEmpty(country) && StringUtils.isNotEmpty(state) && StringUtils.isNotEmpty(goodType);
        }
    }
}
