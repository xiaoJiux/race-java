package com.example.fzp.mapper;

import com.example.fzp.entity.Headlines;
import com.example.fzp.entity.HeadlinesSay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface headlinesSayMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg, hs.`name` headlinesName, hs.img headlinesImg, hs.content headlinesContent FROM headlinesSay h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` hs ON h.`headlines` = hs.id ")
    List<HeadlinesSay> findAll();

    @Select("SELECT *, u.`name` userName, u.img userImg, hs.`name` headlinesName, hs.img headlinesImg, hs.content headlinesContent FROM headlinesSay h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` hs ON h.`headlines` = hs.id WHERE h.id = #{id}")
    List<HeadlinesSay> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, hs.`name` headlinesName, hs.img headlinesImg, hs.content headlinesContent FROM headlinesSay h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` hs ON h.`headlines` = hs.id WHERE h.`user` = #{id}")
    List<HeadlinesSay> findByUserId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, hs.`name` headlinesName, hs.img headlinesImg, hs.content headlinesContent FROM headlinesSay h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` hs ON h.`headlines` = hs.id WHERE h.`headlines` = #{id}")
    List<HeadlinesSay> findByHeadlinesId(Long id);


    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, hs.`name` headlinesName, hs.img headlinesImg FROM headlinesSay h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` hs ON h.`headlines` = hs.id"
            +" where 1=1"
            +"<when test= 'headlines != -1'> and h.`headlines`= #{headlines} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<HeadlinesSay> findHeadlinesSayByPage(@Param("page") int page, @Param("limit") int limit, @Param("headlines") int headlines, @Param("userId") int userId);


    @Insert("INSERT INTO `headlinesSay` (`say`, `date`, user, headlines) VALUES (#{say}, #{date}, #{user}, #{headlines});")
    Integer save(HeadlinesSay headlinesSay);

    @Update("UPDATE `headlinesSay` SET say = #{say}, date = #{date}, user = #{user}, headlines = #{headlines} WHERE `id` = #{id}")
    Integer updateById(HeadlinesSay headlinesSay);

    @Delete("DELETE FROM headlinesSay WHERE id = #{id}")
    Integer DeleteById(Long id);
}
