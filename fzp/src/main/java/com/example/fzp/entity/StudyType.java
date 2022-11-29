package com.example.fzp.entity;

import lombok.Data;

@Data
public class StudyType {    //文章类型(外键)
    int id;
    String type;            //如案例、心理篇、技术篇等
}
