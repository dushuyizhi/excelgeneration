package com.liu.excelgeneration.util.GenExcel.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.List;

@Data
public class StockModel extends BaseRowModel {
    /**
     * value: 表头名称
     * index: 列的号, 0表示第一列
     */
    @ExcelProperty(value = "客户名称")
    private String customerName;

    @ExcelProperty(value = "证件号码")
    private String identificationNumber;
    @ExcelProperty(value = "合同编号")
    private String contractNo;
    @ExcelProperty(value = "客户号")
    private String customerNumber;

    @ExcelProperty(value = "实还本金")
    private String paidInPrincipal;
    @ExcelProperty(value = "实还利息")
    private String interestPaidIn;

    private List<Plan> plans;




}
