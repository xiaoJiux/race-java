package com.example.fzp.mapper;

import com.example.fzp.entity.Sign;
import com.example.fzp.entity.StudySay;
import com.example.fzp.entity.StudySayUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studySayUserMapper {
    @Select("SELECT *, line.`name` studyName, line.img studyImg, u1.`name` sayUserName, u1.img sayUserImg, u2.`name` byUserName, u2.img byUserImg, sa.say byUserSay FROM studySayUser h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `studySay` sa ON h.`byUser` = sa.id LEFT JOIN `user` u2 ON sa.`user` = u2.id LEFT JOIN `study` line ON sa.study = line.id")
    List<StudySayUser> findAll();

    @Select("SELECT *, line.`name` studyName, line.img studyImg, u1.`name` sayUserName, u1.img sayUserImg, u2.`name` byUserName, u2.img byUserImg, sa.say byUserSay FROM studySayUser h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `studySay` sa ON h.`byUser` = sa.id LEFT JOIN `user` u2 ON sa.`user` = u2.id LEFT JOIN `study` line ON sa.study = line.id WHERE h.id = #{id}")
    List<StudySayUser> findById(Long id);

    @Select({"<script>"
            +"SELECT *, line.`name` studyName, line.img studyImg, u1.`name` sayUserName, u1.img sayUserImg, u2.`name` byUserName, u2.img byUserImg, sa.say byUserSay FROM studySayUser h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `studySay` sa ON h.`byUser` = sa.id LEFT JOIN `user` u2 ON sa.`user` = u2.id LEFT JOIN `study` line ON sa.study = line.id "
            +" where 1=1 "
            +"<when test= 'byUserId != -1'> and h.`byUser`= #{byUserId} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +" LIMIT #{page},#{limit}"
            +"</script>"})
    List<StudySayUser> findByPage(@Param("page") int page, @Param("limit") int limit, @Param("byUserId") int byUserId, @Param("userId") int userId);


    @Select("SELECT *, line.`name` studyName, line.img studyImg, u1.`name` sayUserName, u1.img sayUserImg, u2.`name` byUserName, u2.img byUserImg, sa.say byUserSay FROM studySayUser h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `studySay` sa ON h.`byUser` = sa.id LEFT JOIN `user` u2 ON sa.`user` = u2.id LEFT JOIN `study` line ON sa.study = line.id WHERE byUser = #{id}")
    List<StudySayUser> findByStudySayId(Long id);

    @Insert("INSERT INTO `studySayUser` (`say`, `date`, user, byUser) VALUES (#{say}, #{date}, #{user}, #{byUser});")
    Integer save(StudySayUser studySayUser);

    @Update("UPDATE `studySayUser` SET say = #{say}, date = #{date}, user = #{user}, byUser = #{byUser} WHERE `id` = #{id}")
    Integer updateById(StudySayUser studySayUser);

    @Delete("DELETE FROM studySayUser WHERE id = #{id}")
    Integer DeleteById(Long id);
}
