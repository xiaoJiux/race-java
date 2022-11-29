package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Activity {     //活动
    int id;
    String name;            //活动名(标题)
    String location;        //活动地点
    String content;         //活动内容(详情)
    String img;             //活动图片
    String unit;            //举办单位
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date time;              //报名开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date overTime;          //报名截至时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date start;             //活动开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date end;               //活动结束时间
    String userName;        //活动发布人名
    String userImg;         //活动发布人头像
    String userPhone;       //活动发布人手机号
    String stateName;       //活动状态名
    String claim;           //志愿者要求
    int needNum;            //最大人数
    int nowNum;             //已参加人数
    Object list;            //参加用户集合
    String eventName;       //活动名称
    String institute;       //发布学院
    String ins;             //是否在校内
    int number;             //活动人数(最多)
    int state;              //活动状态(外键)
    int user;               //活动发布人(外键)
    int in;                 //是否在校内(外键)
    int dUserSum;
}

//@Data
//public class Activity {     //活动
//    int id;
//    String name;            //活动名(标题)
//    String location;        //活动地点
//    String content;         //活动内容(详情)
//    Date start;             //活动开始时间
//    Date end;               //活动结束时间
//    int number;             //活动人数(最多)
//    int state;              //活动状态(外键)
//    int user;               //活动发布人(外键)
//}
