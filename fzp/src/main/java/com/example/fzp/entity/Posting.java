package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Posting {      //帖子
    int id;
    String name;            //帖子名
    String content;         //帖子内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date date;              //帖子发布时间
    String img;             //帖子封面图(路径)
    int level;              //帖子分类(外键)
    String levelString;
    int opacity;            //帖子是否对外可见(外键)
    String opacityString;
    int user;               //帖子发布人(外键)
    String userName;
    String userImg;
    int likeCOUNT;
    int sayCOUNT;

}
