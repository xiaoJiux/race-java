package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PostingSay {   //帖子评论
    int id;
    String say;             //评论内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;              //帖子评论的时间
    int user;               //评论的用户(外键)
    int posting;            //被评论的帖子(外键)
    String userName;
    String userImg;
    String postingName;
    String postingImg;
    String postingContent;
    int likeCOUNT;
}
