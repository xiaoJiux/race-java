package com.example.fzp.entity;

import lombok.Data;

@Data
public class    StudyLike {//文章点赞or收藏
    int id;
    int user;           //用户(外键)
    int study;          //学习文章(外键)
    int likeType;       //类型(点赞,收藏)(外键)
    String userName;
    String userImg;
    String studyName;
    String studyImg;
    String studyContent;
    String likeTypeString;

}
