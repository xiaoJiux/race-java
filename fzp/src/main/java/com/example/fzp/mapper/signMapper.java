package com.example.fzp.mapper;

import com.example.fzp.entity.PostingSay;
import com.example.fzp.entity.Sign;
import com.example.fzp.entity.Study;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface signMapper {
    @Select("SELECT * FROM sign")
    List<Sign> findAll();

    @Select("SELECT * FROM `sign` WHERE id = #{id}")
    List<Sign> findById(Long id);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, t.type signType, a.`name` activityName, a.img activityImg FROM sign s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `type` t ON s.`type` = t.id LEFT JOIN `activity` a ON s.`activity` = a.id"
            +" where 1=1"
            +"<when test= 'activityId != -1'> and s.`activity`= #{activityId} </when>"
            +"<when test= 'signType != -1'> and s.`type`= #{signType} </when>"
            +"<when test= 'userId != -1'> and s.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<Sign> findSignByPage(@Param("page") int page, @Param("limit") int limit, @Param("activityId") int activityId, @Param("signType") int signType, @Param("userId") int userId);


    @Select("SELECT * FROM `sign` WHERE user = #{userId} AND activity = #{activityId}")
    List<Sign> findByUser(Long userId,Long activityId);

    @Insert("INSERT INTO `sign` (`location`, `date`, user, activity, type) VALUES (#{location}, #{date}, #{user}, #{activity}, #{type});")
    Integer save(Sign sign);

    @Update("UPDATE `sign` SET location = #{location}, date = #{date}, user = #{user}, activity = #{activity}, type = #{type} WHERE `id` = #{id}")
    Integer updateById(Sign sign);

    @Delete("DELETE FROM sign WHERE id = #{id}")
    Integer DeleteById(Long id);
}
