package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Study {    //文章
    int id;
    String name;        //文章名字
    String content;     //文章内容
    String img;         //文章封面路径(路径)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;          //文章发布时间
    String location;    //文章地点(可填)
    int user;           //发表文章用户(外键)
    String userName;
    String userImg;
    int type;           //文章的类型(外键)
    String studyType;
    int likeCOUNT;
    int saveCOUNT;
}
