package com.example.fzp.entity;

import lombok.Data;

@Data
public class HeadlinesLike {
    int id;
    int user;
    int headlines;
    int likeType;
    String userName;
    String userImg;
    String headlinesName;
    String headlineImg;
    String headlineContent;
    String likeTypeString;
}
