package com.example.fzp.entity;

import lombok.Data;

@Data
public class StudySayLike { //文章评论点赞表
    int id;
    int user;               //点赞用户(外键)
    int studySay;           //点赞评论(外键)
    String studyName;
    String studyImg;
    String likeUserName;
    String likeUserImg;
    String sayUserName;
    String sayUserImg;
    String sayContent;
    int likeCOUNT;
    int saveCOUNT;
}
