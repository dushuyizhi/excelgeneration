package com.liu.excelgeneration.entity.task;

import lombok.Builder;
import lombok.Data;

/**
 * 借款单
 */
@Builder
@Data
public class LoanBill {
    /**
     * 总数
     */
    private long total;
    /**
     * 已还
     */
    private long paid;
    /**
     * 还款百分比
     */
    private double repaymentPercentage;
}
