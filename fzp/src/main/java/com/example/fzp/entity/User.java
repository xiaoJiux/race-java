package com.example.fzp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class User {     //用户
    int id;
    String number;      //用户学号/工号
    String password;    //用户密码
    String name;        //用户姓名
    String introduce;   //用户简介
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date birthday;      //用户生日
    String phone;       //用户手机号
    String mail;        //用户邮箱
    String img;         //头像路径
    int sex;            //用户性别(外键)
    String sexString;
    int level;          //用户权限(外键)
    String levelString;
    int institute;      //用户所属学院(外键)
    String instituteString;
}
