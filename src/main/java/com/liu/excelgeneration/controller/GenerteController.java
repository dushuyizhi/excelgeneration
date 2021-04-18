package com.liu.excelgeneration.controller;

import com.liu.excelgeneration.entity.Student;
import com.liu.excelgeneration.entity.Teacher;
import com.liu.excelgeneration.util.ExcelTemplate;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GenerteController {

    @RequestMapping("/down")
    public String demo(){
        return "demo";//地址指向demo.html
    }

        @RequestMapping("generte")
    public void generte(HttpServletResponse response) throws Exception {
            ExcelTemplate et = ExcelTemplate.getInstance()
                    .readTemplateByClasspath("static/testSheel.xlsx");
            List<Teacher> teachers = initData();
            for(int i = 0; i < teachers.size(); i++){
                List<Student> students = teachers.get(i).getStudent();
                et.setSheet(teachers.size(),teachers.get(i).getNum());
                for(Student student : students){
                    et.createNewRow();
                    et.createCell(student.getName());
                    et.createCell(student.getSex());
                    et.createCell(student.getAge());
                }
            }


            String fileName = "三国信息表.xlsx";

            //设置Http响应头告诉浏览器下载这个附件,下载的文件名也是在这里设置的
                response.setContentType("application/x-msdownload;charset=UTF-8");
                response.setHeader("Content-Disposition",
                        "attachment;Filename=" + URLEncoder.encode(fileName, "UTF-8"));
                et.writeToStream(response.getOutputStream());
    }

    public static List<Teacher> initData(){
        Student student1 = new Student("刘备","男","38");
        Student student2 = new Student("张飞","男","35");
        Student student3 = new Student("关羽","男","36");
        Student student4 = new Student("孙权","男","38");
        Student student5 = new Student("周瑜","男","35");
        Student student6 = new Student("鲁肃","男","36");

        Teacher teacher1 = Teacher.builder().num("蜀国").student(Lists.newArrayList(student1, student2, student3)).build();
        Teacher teacher2 = Teacher.builder().num("吴国").student(Lists.newArrayList(student4, student5, student6)).build();
        Teacher teacher3 = Teacher.builder().num("吴国2").student(Lists.newArrayList(student4, student2, student6)).build();
        List<Teacher> lists = Lists.newArrayList(teacher1,teacher2,teacher3);
        return  lists;
    }

}
