package com.example.fzp.mapper;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.HeadlinesSayLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface headlinesLikeMapper {
    @Select("SELECT * FROM headlinesLike")
    List<HeadlinesLike> findAll();

    @Select("SELECT * FROM `headlinesLike` WHERE id = #{id}")
    List<HeadlinesLike> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, line.`name` headlinesName, line.img headlineImg, line.content headlinesContent, lt.likeType likeTypeString FROM headlinesLike h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` line ON h.headlines = line.id LEFT JOIN `liketype` lt ON h.liketype = lt.id WHERE h.`user` = #{id} AND h.likeType = 2")
    List<HeadlinesLike> findByLikeTypeId(Long id);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, line.`name` headlinesName, line.img headlineImg, lt.likeType likeTypeString FROM headlinesLike h LEFT JOIN `user` u ON h.`user` = u.id LEFT JOIN `headlines` line ON h.headlines = line.id LEFT JOIN `liketype` lt ON h.liketype = lt.id"
            +" where 1=1"
            +"<when test= 'headlinesId != -1'> and h.`headlines`= #{headlinesId} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +"<when test= 'likeType != -1'> and h.`likeType`= #{likeType} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<HeadlinesLike> findHeadlinesLikeByPage(@Param("page") int page, @Param("limit") int limit, @Param("headlinesId") int headlinesId, @Param("userId") int userId, @Param("likeType") int likeType);

    @Select("SELECT COUNT(id) COUNTLike FROM headlinesLike WHERE headlines = #{id} AND likeType = 1")
    Integer findByLikeType1COUNT(Long id);

    @Select("SELECT COUNT(id) COUNTSave FROM headlinesLike WHERE headlines = #{id} AND likeType = 2")
    Integer findByLikeType2COUNT(Long id);

    @Insert("INSERT INTO `headlinesLike` (`user`, `headlines`, `likeType`) VALUES (#{user}, #{headlines}, #{likeType});")
    Integer save(HeadlinesLike headlinesSayLike);

    @Update("UPDATE `headlinesLike` SET user = #{user}, headlines = #{headlines}, likeType = #{likeType} WHERE `id` = #{id}")
    Integer updateById(HeadlinesLike headlinesSayLike);

    @Delete("DELETE FROM headlinesLike WHERE id = #{id}")
    Integer DeleteById(Long id);
}
