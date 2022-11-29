package com.example.fzp.mapper;

import com.example.fzp.entity.Points;
import com.example.fzp.entity.Posting;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface postingMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg, l.`level` levelString, o.opacity opacityString FROM posting p LEFT JOIN `user` u ON p.`user` = u.id LEFT JOIN `postingLevel` l ON p.`level` = l.id LEFT JOIN `opacity` o ON p.`opacity` = o.id ")
    List<Posting> findAll();

    @Select("SELECT *,u.`name` userName, u.img userImg FROM posting p LEFT JOIN `user` u ON p.`user` = u.id WHERE p.`level` = 1 ORDER BY date DESC LIMIT 2")
    List<Posting> findAllIndex();

    @Select("SELECT *, u.`name` userName, u.img userImg, l.`level` levelString, o.opacity opacityString FROM posting p LEFT JOIN `user` u ON p.`user` = u.id LEFT JOIN `postingLevel` l ON p.`level` = l.id LEFT JOIN `opacity` o ON p.`opacity` = o.id WHERE p.id = #{id}")
    List<Posting> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, l.`level` levelString, o.opacity opacityString FROM posting p LEFT JOIN `user` u ON p.`user` = u.id LEFT JOIN `postingLevel` l ON p.`level` = l.id LEFT JOIN `opacity` o ON p.`opacity` = o.id WHERE p.user = #{id}")
    List<Posting> findByUserId(Long id);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, l.`level` levelString, o.opacity opacityString FROM posting p LEFT JOIN `user` u ON p.`user` = u.id LEFT JOIN `postingLevel` l ON p.`level` = l.id LEFT JOIN `opacity` o ON p.`opacity` = o.id"
            +" where 1=1"
            +"<when test= 'name != null'> and p.`name` LIKE #{name} </when>"
            +"<when test= 'opacityId != -1'> and p.`opacity`= #{opacityId} </when>"
            +"<when test= 'levelId != -1'> and p.`level`= #{levelId} </when>"
            +"<when test= 'userId != -1'> and p.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<Posting> findPostingByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name, @Param("opacityId") int opacityId, @Param("levelId") int levelId, @Param("userId") int userId);


    @Insert("INSERT INTO `posting` (`name`, `content`, `date`, img, level, opacity, user) VALUES (#{name}, #{content}, #{date}, #{img}, #{level}, #{opacity}, #{user});")
    Integer save(Posting posting);

    @Update("UPDATE `posting` SET name = #{name}, content = #{content}, date = #{date}, img = #{img}, level = #{level}, opacity = #{opacity}, user = #{user} WHERE `id` = #{id}")
    Integer updateById(Posting posting);

    @Delete("DELETE FROM posting WHERE id = #{id}")
    Integer DeleteById(Long id);
}
