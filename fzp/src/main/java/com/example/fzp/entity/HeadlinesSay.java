package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class HeadlinesSay {     //头条评论
    int id;
    String say;         //评论内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;          //评论时间
    int user;           //评论用户(外键)
    int headlines;      //评论头条(外键)
    String userName;
    String userImg;
    String headlinesName;
    String headlinesImg;
    String headlinesContent;
    int likeCOUNT;


}
