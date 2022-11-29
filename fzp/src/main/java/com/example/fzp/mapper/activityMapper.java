package com.example.fzp.mapper;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface activityMapper {
    @Select("SELECT *, a.number needNum, a.NAME eventName, a.content, a.`start`, a.`end`, a.location, a.unit, a.claim, a.img, a.time, a.overTime, u.NAME userName, u.phone userPhone, s.state stateName, i.institute institute, ins.`in` ins FROM `fzp`.`activity` a LEFT JOIN `fzp`.`state` s ON a.state = s.id LEFT JOIN `fzp`.`user` u ON a.USER = u.id LEFT JOIN institute i ON u.institute = i.id LEFT JOIN `fzp`.`in` ins ON a.`in` = ins.id")
    List<Activity> findAll();

    @Select("SELECT *, a.number needNum, a.NAME eventName, a.content, a.`start`, a.`end`, a.location, a.unit, a.claim, a.img, a.time, a.overTime, u.NAME userName, u.phone userPhone, s.state stateName, i.institute institute, ins.`in` ins FROM `fzp`.`activity` a LEFT JOIN `fzp`.`state` s ON a.state = s.id LEFT JOIN `fzp`.`user` u ON a.USER = u.id LEFT JOIN institute i ON u.institute = i.id LEFT JOIN `fzp`.`in` ins ON a.`in` = ins.id ORDER BY time DESC  LIMIT 3")
    List<Activity> findAllIndex();

    @Select("SELECT * FROM ( SELECT j.user,j.activity FROM `fzp`.`join` j WHERE activity = #{activity} ) s LEFT JOIN `user` u ON s.`user` = u.id")
    List<User> findUserForActivityList(Long activity);

    @Select("SELECT *, a.number needNum, a.NAME eventName, a.content, a.`start`, a.`end`, a.location, a.unit, a.claim, a.img, a.time, a.overTime, u.`name` userName, u.phone userPhone, s.state stateName, i.institute institute, ins.`in` ins FROM `fzp`.`activity` a LEFT JOIN `fzp`.`state` s ON a.state = s.id LEFT JOIN `fzp`.`user` u ON a.USER = u.id LEFT JOIN institute i ON u.institute = i.id LEFT JOIN `fzp`.`in` ins ON a.`in` = ins.id WHERE a.id = #{id}")
    List<Activity> findById(Long id);

    @Select("SELECT *, a.number needNum, a.`name` eventName, a.content, a.`start`, a.`end`, a.location, a.unit, a.claim, a.img, a.time, a.overTime, u.`name` userName, u.phone userPhone, s.state stateName, i.institute institute, ins.`in` ins FROM `fzp`.`activity` a LEFT JOIN `fzp`.`state` s ON a.state = s.id LEFT JOIN `fzp`.`user` u ON a.USER = u.id LEFT JOIN institute i ON u.institute = i.id LEFT JOIN `fzp`.`in` ins ON a.`in` = ins.id WHERE a.`user` = #{id} ORDER BY a.time DESC")
    List<Activity> findByUserId(Long id);

    @Select({"<script>"
            +"SELECT *, a.number needNum, a.NAME eventName, a.content, a.`start`, a.`end`, a.location, a.unit, a.claim, a.img, a.time, a.overTime, u.NAME userName, u.phone userPhone, u.img userImg, s.state stateName, i.institute institute, ins.`in` ins FROM `fzp`.`activity` a LEFT JOIN `fzp`.`state` s ON a.state = s.id LEFT JOIN `fzp`.`user` u ON a.USER = u.id LEFT JOIN institute i ON u.institute = i.id LEFT JOIN `fzp`.`in` ins ON a.`in` = ins.id "
            +" where 1=1 "
            +"<when test= 'name != null'> and a.`name` LIKE #{name} </when>"
            +"<when test= 'location != null'> and a.`location` LIKE #{location} </when>"
            +"<when test= 'unit != null'> and a.`unit` LIKE #{unit} </when>"
            +"<when test= 'state != -1'> and a.`state`= #{state} </when>"
            +"<when test= 'userId != -1'> and a.`user`= #{userId} </when>"
            +"<when test= 'ins != -1'> and a.`in`= #{ins} </when>"
            +" LIMIT #{page},#{limit}"
            +"</script>"})
    List<Activity> findActivityByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name, @Param("location") String location, @Param("unit") String unit, @Param("userId") int userId, @Param("state") int state, @Param("ins") int ins);


    @Insert("INSERT INTO `activity` (`name`, `location`, `content`, `img`, `unit`, `time`, `overTime`, `start`, `end`, `claim`, `number`, `state`, `user`, `in`) VALUES (#{name}, #{location}, #{content}, #{img}, #{unit}, #{time}, #{overTime}, #{start}, #{end}, #{claim}, #{number}, #{state}, #{user}, #{in});")
    Integer save(Activity activity);

    @Update("UPDATE `activity` SET name = #{name}, location = #{location}, content = #{content}, img = #{img}, unit = #{unit}, time = #{time}, overTime = #{overTime}, start = #{start}, end = #{end}, claim = #{claim}, number = #{number}, state = #{state}, user = #{user}, `in` = #{in} WHERE `id` = #{id}")
    Integer updateById(Activity activity);

    @Delete("DELETE FROM activity WHERE id = #{id}")
    Integer DeleteById(Long id);
}
