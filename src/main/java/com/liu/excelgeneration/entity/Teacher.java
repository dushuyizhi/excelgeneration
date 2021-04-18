package com.liu.excelgeneration.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Teacher {
    private List<Student> student;
    private String num;
}
