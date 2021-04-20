package com.liu.excelgeneration.entity.task;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class GeneraDataUtil {
    public static List<Order> getOrder(){
        List<Order> orders = new ArrayList<>();
        for(int j = 0; j <5; j++){
            List<LoanBill> loanBills = new ArrayList<>();
            for(int i = 0; i <3; i++){
                LoanBill loanBill = LoanBill.builder().total(1000L + (i*2)).paid(500 + (i*2))
                        .repaymentPercentage(0.5).build();
                loanBills.add(loanBill);
            }
            Order order = Order.builder().dateTime("2021041" + j).custom("custom")
                    .loanBills(loanBills).build();
            orders.add(order);
        }
        return  orders;
    }

    public static void main(String[] args) {
        System.out.println(getOrder());
    }
}
