package com.example.fzp.mapper;

import com.example.fzp.entity.Study;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface studyMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id  ")
    List<Study> findAll();

    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id  WHERE s.type = 1 OR s.type = 2 OR s.type = 4 OR s.type = 7")
    List<Study> findAllOR();

    @Select("SELECT *, u.`name` userName, u.img userImg,s.date createDate, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.type = 5")
    List<Study> findAllVision();

    @Select("SELECT *, u.`name` userName, u.img userImg,s.date createDate, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.type = 9")
    List<Study> findAllTiktok();
//    DATE_FORMAT(s.date, '%Y-%m-%d %H:%i:%s')
    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.type = 5 AND s.id = #{id}")
    List<Study> findByVisionId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.type = 9 AND s.id = #{id}")
    List<Study> findByTiktokId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.id = #{id}")
    List<Study> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.`user` = #{id}")
    List<Study> findByUserId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.`user` = #{id} AND s.`type` = 5")
    List<Study> findByVisionUserId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id WHERE s.`user` = #{id} AND s.`type` = 9")
    List<Study> findByTiktokUserId(Long id);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, st.type studyType FROM study s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `studytype` st ON s.`type` = st.id "
            +" where 1=1 "
            +"<when test= 'name != null'> and s.`name` LIKE #{name} </when>"
            +"<when test= 'location != null'> and s.`location` Like #{location} </when>"
            +"<when test= 'studyType != -1'> and s.`type`= #{studyType} </when>"
            +"<when test= 'userId != -1'> and s.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<Study> findPostingByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name, @Param("location") String location, @Param("studyType") int studyType, @Param("userId") int userId);


    @Insert("INSERT INTO `study` (`name`, `content`, img, date, location, user, type) VALUES (#{name}, #{content}, #{img}, #{date}, #{location}, #{user}, #{type});")
    Integer save(Study study);

    @Update("UPDATE `study` SET name = #{name}, content = #{content}, img = #{img}, date = #{date}, location = #{location}, user = #{user}, type = #{type} WHERE `id` = #{id}")
    Integer updateById(Study study);

    @Delete("DELETE FROM study WHERE id = #{id}")
    Integer DeleteById(Long id);

}
