package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Sign {     //活动签到表
    int id;
    String location;    //签到地点
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;          //签到时间
    int user;           //签到用户(外键)
    int activity;       //签到活动(外键)
    int type;           //签到状态(外键)
    String userName;
    String userImg;
    String signType;
    String activityName;
    String activityImg;
}
