package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class StudySay {//文章评论
    int id;
    String say;        //评论内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;         //评论时间
    int user;          //评论用户(外键)
    int study;         //评论文章(外键)
    int like;
    int save;
    String userName;
    String userImg;
    String studyName;
    String studyImg;
    String studyType;
    String studyContent;
    Object childrenSay;
    int likeCOUNT;
}
