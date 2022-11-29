package com.example.fzp.mapper;

import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.StudyLike;
import com.example.fzp.entity.StudySay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studySayMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id")
    List<StudySay> findAll();

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE a.id = #{id}")
    List<StudySay> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE s.type = 5 AND a.id = #{id}")
    List<StudySay> findByVisionId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE s.type = 9 AND a.id = #{id}")
    List<StudySay> findByTiktokId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE a.study = #{id}")
    List<StudySay> findByStudyId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.type studyType, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE a.`user` = #{id}")
    List<StudySay> findByUserId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE s.`id` = #{id} AND s.type = 5")
    List<StudySay> findByVisionSayVisionId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE s.`id` = #{id} AND s.type = 9")
    List<StudySay> findByTiktokSayTiktokId(Long id);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id "
            +"WHERE 1=1 "
            +"<when test= 'studyId != -1'> and a.`study`= #{studyId} </when>"
            +"<when test= 'userId != -1'> and a.`user`= #{userId} </when>"
            +" LIMIT #{page},#{limit}"
            +"</script>"})
    List<StudySay> findByPage(@Param("page") int page, @Param("limit") int limit, @Param("studyId") int studyId, @Param("userId") int userId);


    @Insert("INSERT INTO `studySay` (`say`, `date`, user, study) VALUES (#{say}, #{date}, #{user}, #{study});")
    Integer save(StudySay studySay);

    @Update("UPDATE `studySay` SET say = #{say}, date = #{date}, user = #{user}, study = #{study} WHERE `id` = #{id}")
    Integer updateById(StudySay studySay);

    @Delete("DELETE FROM studySay WHERE id = #{id}")
    Integer DeleteById(Long id);



    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE s.type = 5")
    List<StudySay> findVisionAll();


    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE a.`user` = #{id} AND s.type = 5")
    List<StudySay> findByVisionUserId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE s.type = 9")
    List<StudySay> findTiktokAll();


    @Select("SELECT *, u.`name` userName, u.img userImg, s.`name` studyName, s.img studyImg, s.content studyContent FROM studySay a LEFT JOIN `user` u ON a.`user` = u.id LEFT JOIN `study` s ON a.`study` = s.id WHERE a.`user` = #{id} AND s.type = 9")
    List<StudySay> findByTiktokUserId(Long id);

}
