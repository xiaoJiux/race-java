package com.example.fzp.entity;

import lombok.Data;

@Data
public class Join {     //活动报名表
    int id;
    int user;           //报名用户(外键)
    int activity;       //报名活动(外键)
    int examine;        //审核状态
    String userName;
    String userImg;
    String activityName;
    String activityImg;
    String examineString;
    String userInstitute;
}
