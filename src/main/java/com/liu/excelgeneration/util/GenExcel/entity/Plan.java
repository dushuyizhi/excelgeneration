package com.liu.excelgeneration.util.GenExcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Plan {
    @ExcelProperty(value = "期数")
    private String numberOfPeriods;
    @ExcelProperty(value = "应还日期")
    private String dueDate;
    @ExcelProperty(value = "实际还款日期")
    private String actualRepaymentDate;
    @ExcelProperty(value = "计划应还总额")
    private String totalAmountPlan;
    @ExcelProperty(value = "期供本金")
    private String principalDue;
    @ExcelProperty(value = "期供利息")
    private String interestPayable;
    @ExcelProperty(value = "未还总额")
    private String totalOutstanding;
    @ExcelProperty(value = "未还本金")
    private String outstandingPrincipal;
    @ExcelProperty(value = "未还利息")
    private String outstandingInterest;
    @ExcelProperty(value = "未还罚息")
    private String interestNotPaid ;
    @ExcelProperty(value = "未还复息")
    private String nointerestPaid;
    @ExcelProperty(value = "实际应还金额")
    private String actualAmountdue;
    @ExcelProperty(value = "本期状态")
    private String currentstatus;
    @ExcelProperty(value = "结清标志")
    private String clearingSign;
}
