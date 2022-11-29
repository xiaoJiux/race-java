package com.example.fzp.mapper;

import com.example.fzp.entity.Join;
import com.example.fzp.entity.Study;
import com.example.fzp.entity.StudyLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studyLikeMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent, l.likeType likeTypeString FROM studyLike a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id LEFT JOIN `likeType` l ON a.`likeType` = l.id ")
    List<StudyLike> findAll();

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent, l.likeType likeTypeString FROM studyLike a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id LEFT JOIN `likeType` l ON a.`likeType` = l.id WHERE a.user = #{id} AND a.likeType = 1")
    List<StudyLike> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent, l.likeType likeTypeString FROM studyLike a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id LEFT JOIN `likeType` l ON a.`likeType` = l.id WHERE a.user = #{id} AND a.likeType = 2")
    List<StudyLike> findByLikeTypeId(Long id);

    @Select("SELECT COUNT(id) COUNTLike FROM studyLike WHERE study = #{id} AND likeType = 1")
    Integer findByLikeType1COUNT(Long id);

    @Select("SELECT COUNT(id) COUNTSave FROM studyLike WHERE study = #{id} AND likeType = 2")
    Integer findByLikeType2COUNT(Long id);



    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, l.likeType likeTypeString FROM studyLike a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id LEFT JOIN `likeType` l ON a.`likeType` = l.id "
            +"where 1=1 "
            +"<when test= 'studyId != -1'> and a.`study`=  #{studyId} </when>"
            +"<when test= 'likeType != -1'> and a.`likeType`=  #{likeType} </when>"
            +"<when test= 'userId != -1'> and a.`user`= #{userId} </when>"
            +" LIMIT #{page},#{limit}"
            +"</script>"})
    List<StudyLike> findByPage(@Param("page") int page, @Param("limit") int limit, @Param("studyId") int studyId, @Param("likeType") int likeType, @Param("userId") int userId);


    @Insert("INSERT INTO `studyLike` (`user`, `study`, likeType) VALUES (#{user}, #{study}, #{likeType});")
    Integer save(StudyLike studyLike);

    @Update("UPDATE `studyLike` SET user = #{user}, study = #{study}, likeType = #{likeType} WHERE `id` = #{id}")
    Integer updateById(StudyLike studyLike);

    @Delete("DELETE FROM studyLike WHERE id = #{id}")
    Integer DeleteById(Long id);
}
