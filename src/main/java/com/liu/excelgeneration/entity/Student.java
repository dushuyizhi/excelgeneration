package com.liu.excelgeneration.entity;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String age;
    private String sex;

    public Student( String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
