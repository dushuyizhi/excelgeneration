package com.liu.excelgeneration.util.GenExcel.entity;

import java.util.ArrayList;
import java.util.List;

public class GeneraDataUtil {
    public static StockModel getData(){
        StockModel stockModel = new StockModel();
        stockModel.setContractNo("12134");
        stockModel.setCustomerName("lz");
        stockModel.setCustomerNumber("123");
        stockModel.setIdentificationNumber("1234567894855");
        stockModel.setInterestPaidIn("intersetpaidin");
        stockModel.setPaidInPrincipal("0.50");
        List<Plan> plans = new ArrayList<>();
        stockModel.setPlans(plans);
        for(int i = 0; i < 10; i++){
            Plan plan = new Plan();
            plan.setNumberOfPeriods("0.1" + i);
            plan.setDueDate("2021041" + i);
            plan.setActualAmountdue("100" + i);
            plan.setActualRepaymentDate("2021042" + i);
            plan.setClearingSign("N" + i);
            plan.setCurrentstatus("fail" + i);
            plan.setInterestNotPaid("100" + i);
            plan.setOutstandingInterest("50" + i);
            plan.setTotalAmountPlan("1000" + i);
            plan.setPrincipalDue("2021051" + i);
            plan.setOutstandingPrincipal("0.01"+ i);
            plan.setTotalOutstanding("200" + i);
            plan.setNointerestPaid("100" + i);
            plan.setInterestPayable("Y" + i);
            plans.add(plan);
        }
        return  stockModel;
    }

    public static void main(String[] args) {
        System.out.println(getData());
    }
}
