package com.example.fzp.entity;

import lombok.Data;

@Data
public class HeadlinesSayLike {     //头条评论点赞表
    int id;
    int user;               //头条评论点赞的用户(外键)
    int headlinesSay;       //点赞的头条评论(外键)
    String headlinesName;
    String headlinesImg;
    String likeUserName;
    String likeUserImg;
    String sayUserName;
    String sayUserImg;
    String sayContent;

}
