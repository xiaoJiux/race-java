package com.example.fzp.entity;

import lombok.Data;

@Data
public class Points {   //用户积分表
    int id;
    int number;         //积分数量
    String info;        //积分详情
    int user;           //积分用户(外键)
    int add;            //执行用户(外键)
    int type;
    int type1;
    int type2;
    int type3;
    int type4;
    int type5;
    int type6;
    int COUNTID;
    String img;
    String numId;
    String name;
    String addName;
    String sumNumber;
    String userName;
    String userImg;
    String userInstitute;
    String instituteImg;
    int clockDay;

}
