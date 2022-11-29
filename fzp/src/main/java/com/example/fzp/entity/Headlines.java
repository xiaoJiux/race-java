package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Headlines {    //头条
    int id;
    String name;        //头条名字
    String content;     //头条内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;          //头条发布时间
    String img;         //头条封面图(路径)
    int user;           //头条发布人(外键)
    String userName;
    String userImg;
    int likeCOUNT;
    int saveCOUNT;
}
