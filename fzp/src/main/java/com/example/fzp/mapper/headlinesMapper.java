package com.example.fzp.mapper;

import com.example.fzp.entity.Headlines;
import com.example.fzp.entity.Study;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface headlinesMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg FROM headlines h LEFT JOIN `user` u ON h.`user` = u.id")
    List<Headlines> findAll();

    @Select("SELECT *, u.`name` userName, u.img userImg FROM headlines h LEFT JOIN `user` u ON h.`user` = u.id LIMIT 1")
    List<Headlines> findAllIndex();

    @Select("SELECT *, u.`name` userName, u.img userImg FROM headlines h LEFT JOIN `user` u ON h.`user` = u.id WHERE h.id = #{id}")
    List<Headlines> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg FROM headlines h LEFT JOIN `user` u ON h.`user` = u.id WHERE h.user = #{id}")
    List<Headlines> findByUserId(Long id);



    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg FROM headlines h LEFT JOIN `user` u ON h.`user` = u.id"
            +" where 1=1"
            +"<when test= 'name != null'> and h.`name` LIKE #{name} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<Headlines> findHeadlinesByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name, @Param("userId") int userId);


    @Insert("INSERT INTO `headlines` (`name`, `content`, img, date, user) VALUES (#{name}, #{content}, #{img}, #{date}, #{user});")
    Integer save(Headlines headlines);

    @Update("UPDATE `headlines` SET name = #{name}, content = #{content}, date = #{date}, img = #{img}, user = #{user} WHERE `id` = #{id}")
    Integer updateById(Headlines headlines);

    @Delete("DELETE FROM headlines WHERE id = #{id}")
    Integer DeleteById(Long id);
}
