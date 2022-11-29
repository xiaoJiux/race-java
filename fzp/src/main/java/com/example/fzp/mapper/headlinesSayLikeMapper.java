package com.example.fzp.mapper;

import com.example.fzp.entity.Headlines;
import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.HeadlinesSayLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface headlinesSayLikeMapper {
    @Select("SELECT *, line.`name` headlinesName, line.img headlinesImg, u1.`name` likeUserName, u1.img likeUserImg, u2.`name` sayUserName, u2.img sayUserImg, hs.say sayContent FROM headlinesSayLike h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `headlinesSay` hs ON h.`headlinesSay` = hs.id LEFT JOIN `user` u2 ON hs.`user` = u2.id LEFT JOIN `headlines` line ON hs.headlines = line.id")
    List<HeadlinesSayLike> findAll();

    @Select("SELECT *, line.`name` headlinesName, line.img headlinesImg, u1.`name` likeUserName, u1.img likeUserImg, u2.`name` sayUserName, u2.img sayUserImg, hs.say sayContent FROM headlinesSayLike h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `headlinesSay` hs ON h.`headlinesSay` = hs.id LEFT JOIN `user` u2 ON hs.`user` = u2.id LEFT JOIN `headlines` line ON hs.headlines = line.id WHERE id = #{id}")
    List<HeadlinesSayLike> findById(Long id);

    @Select({"<script>"
            +"SELECT *, line.`name` headlinesName, line.img headlinesImg, u1.`name` likeUserName, u1.img likeUserImg, u2.`name` sayUserName, u2.img sayUserImg, hs.say sayContent FROM headlinesSayLike h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `headlinesSay` hs ON h.`headlinesSay` = hs.id LEFT JOIN `user` u2 ON hs.`user` = u2.id LEFT JOIN `headlines` line ON hs.headlines = line.id"
            +" where 1=1"
            +"<when test= 'headlinesSayId != -1'> and h.`headlinesSay`= #{headlinesSayId} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<HeadlinesSayLike> findHeadlinesSayLikeByPage(@Param("page") int page, @Param("limit") int limit, @Param("headlinesSayId") int headlinesSayId, @Param("userId") int userId);

    @Select("SELECT COUNT(id) COUNTLike FROM headlinesSayLike WHERE headlinesSay = #{id} ")
    Integer findByLikeType1COUNT(Long id);



    @Insert("INSERT INTO `headlinesSayLike` (`user`, `headlinesSay`) VALUES (#{user}, #{headlinesSay});")
    Integer save(HeadlinesSayLike headlinesSayLike);

    @Update("UPDATE `headlinesSayLike` SET user = #{user}, headlinesSay = #{headlinesSay} WHERE `id` = #{id}")
    Integer updateById(HeadlinesSayLike headlinesSayLike);

    @Delete("DELETE FROM headlinesSayLike WHERE id = #{id}")
    Integer DeleteById(Long id);
}
