package com.liu.excelgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class GenerteLZController {

    @RequestMapping("/downExcel")
    public String demo(){
        return "downExcel";//地址指向demo.html
    }

    public static void main(String[] args) {
        System.out.println(File.separator);
    }







}
