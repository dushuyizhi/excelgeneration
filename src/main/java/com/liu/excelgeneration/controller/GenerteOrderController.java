package com.liu.excelgeneration.controller;

import com.liu.excelgeneration.entity.Student;
import com.liu.excelgeneration.entity.Teacher;
import com.liu.excelgeneration.entity.task.GeneraDataUtil;
import com.liu.excelgeneration.entity.task.LoanBill;
import com.liu.excelgeneration.entity.task.Order;
import com.liu.excelgeneration.util.ExcelTemplate;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class GenerteOrderController {



    @RequestMapping("generteOrder")
    public String generte(HttpServletResponse response) throws Exception {
            ExcelTemplate et = ExcelTemplate.getInstance()
                    .readTemplateByClasspath("static/order.xlsx");
        List<Order> orders = GeneraDataUtil.getOrder();
        for(int i = 0; i < orders.size(); i++){
            et.createNewRow();
            et.createCell(orders.get(i).getDateTime());
            et.createCell(orders.get(i).getCustom());
            for(LoanBill loanBill : orders.get(i).getLoanBills()){
                et.createCell(loanBill.getTotal());
                et.createCell(loanBill.getPaid());
                et.createCell(loanBill.getRepaymentPercentage());
            }
        }

        String fileName = "order.xlsx";

        //设置Http响应头告诉浏览器下载这个附件,下载的文件名也是在这里设置的
        response.setContentType("application/x-msdownload;charset=UTF-8");
        response.setHeader("Content-Disposition",
                "attachment;Filename=" + URLEncoder.encode(fileName, "UTF-8"));
        et.writeToStream(response.getOutputStream());
        return  "Success!";

    }

    @RequestMapping("downOrder")
    public String downOrder(){
        return "order";
    }

}
