package com.liu.excelgeneration.entity.task;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    /**
     * 时间
     */
    private String dateTime;
    /**
     * 自定义预留字段
     */
    private String custom;
    /**
     * 借据
     */
    private List<LoanBill> loanBills;

}
