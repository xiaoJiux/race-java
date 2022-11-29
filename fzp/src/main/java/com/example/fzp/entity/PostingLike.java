package com.example.fzp.entity;

import lombok.Data;

@Data
public class PostingLike {   //帖子点赞
    int id;
    int user;               //用户ID(外键）
    int posting;            //帖子ID(外键)
    int likeType;
    String userName;
    String userImg;
    String postingName;
    String postingImg;
    String postingContent;
}
