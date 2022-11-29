package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class StudySayUser { //评论用户评论
    int id;
    String say;             //评论内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;              //评论时间
    int user;               //评论用户(外键)
    int byUser;             //被评论的用户(外键)
    String studyName;
    String studyImg;
    String sayUserName;
    String sayUserImg;
    String byUserName;
    String byUserImg;
    String byUserSay;

}
