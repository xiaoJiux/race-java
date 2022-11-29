package com.example.fzp.entity;

import lombok.Data;

@Data
public class PostingSayLike {   //帖子评论点赞
    int id;
    int user;                   //评论点赞的用户(外键)
    int postingSay;             //被用户点赞的评论(外键)
    String postingName;
    String postingImg;
    String likeUserName;
    String likeUserImg;
    String sayUserName;
    String sayUserImg;
    String sayContent;
}
