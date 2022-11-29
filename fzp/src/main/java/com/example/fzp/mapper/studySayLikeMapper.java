package com.example.fzp.mapper;

import com.example.fzp.entity.StudyLike;
import com.example.fzp.entity.StudySay;
import com.example.fzp.entity.StudySayLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studySayLikeMapper {
    @Select("SELECT * FROM studySayLike")
    List<StudySayLike> findAll();

    @Select("SELECT * FROM `studySayLike` WHERE id = #{id}")
    List<StudySayLike> findById(Long id);

    @Select({"<script>"
            +"SELECT *, line.`name` studyName, line.img studyImg, u1.`name` likeUserName, u1.img likeUserImg, u2.`name` sayUserName, u2.img sayUserImg, hs.say sayContent FROM studySayLike h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `studySay` hs ON h.`studySay` = hs.id LEFT JOIN `user` u2 ON hs.`user` = u2.id LEFT JOIN `study` line ON hs.study = line.id "
            +" WHERE 1=1 "
            +"<when test= 'studySayId != -1'> and h.`studySay`= #{studySayId} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +" LIMIT #{page},#{limit}"
            +"</script>"})
    List<StudySayLike> findByPage(@Param("page") int page, @Param("limit") int limit, @Param("studySayId") int studySayId, @Param("userId") int userId);

    @Select("SELECT COUNT(id) COUNTLike FROM studySayLike WHERE studySay = #{id} ")
    Integer findByLikeType1COUNT(Long id);

    @Select("SELECT COUNT(id) COUNTSave FROM studySayLike WHERE studySay = #{id} ")
    Integer findByLikeType2COUNT(Long id);

    @Insert("INSERT INTO `studySayLike` (`user`, `studySay`) VALUES (#{user}, #{studySay});")
    Integer save(StudySayLike studySayLike);

    @Update("UPDATE `studySayLike` SET user = #{user}, studySay = #{studySay} WHERE `id` = #{id}")
    Integer updateById(StudySayLike studySayLike);

    @Delete("DELETE FROM studySayLike WHERE id = #{id}")
    Integer DeleteById(Long id);
}
