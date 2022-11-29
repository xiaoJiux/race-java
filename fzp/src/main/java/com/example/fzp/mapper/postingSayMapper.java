package com.example.fzp.mapper;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.PostingSay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface postingSayMapper {
    @Select("SELECT *, u.`name` userName, u.img userImg, p.`name` postingName, p.`img` postingImg, p.content postingContent FROM postingSay ps LEFT JOIN `user` u ON ps.`user` = u.id LEFT JOIN `posting` p ON ps.`posting` = p.id ")
    List<PostingSay> findAll();

    @Select("SELECT *, u.`name` userName, u.img userImg, p.`name` postingName, p.`img` postingImg, p.content postingContent FROM postingSay ps LEFT JOIN `user` u ON ps.`user` = u.id LEFT JOIN `posting` p ON ps.`posting` = p.id  WHERE ps.id = #{id}")
    List<PostingSay> findById(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, p.`name` postingName, p.`img` postingImg, p.content postingContent FROM postingSay ps LEFT JOIN `user` u ON ps.`user` = u.id LEFT JOIN `posting` p ON ps.`posting` = p.id WHERE ps.`user` = #{id} ")
    List<PostingSay> findByUserId(Long id);

    @Select("SELECT *, u.`name` userName, u.img userImg, p.`name` postingName, p.`img` postingImg, p.content postingContent FROM postingSay ps LEFT JOIN `user` u ON ps.`user` = u.id LEFT JOIN `posting` p ON ps.`posting` = p.id WHERE ps.`posting` = #{id} ")
    List<PostingSay> findByPostingId(Long id);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, p.`name` postingName, p.`img` postingImg FROM postingSay ps LEFT JOIN `user` u ON ps.`user` = u.id LEFT JOIN `posting` p ON ps.`posting` = p.id"
            +" where 1=1"
            +"<when test= 'postingId != -1'> and ps.`posting`= #{postingId} </when>"
            +"<when test= 'userId != -1'> and ps.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<PostingSay> findPostingSayByPage(@Param("page") int page, @Param("limit") int limit, @Param("postingId") int postingId, @Param("userId") int userId);

    @Select("SELECT COUNT( id ) sayCOUNT FROM postingSay WHERE posting = #{posting}")
    Integer findBySayCOUNT(Long posting);

    @Insert("INSERT INTO `postingSay` (`say`, `date`, user, posting) VALUES (#{say}, #{date}, #{user}, #{posting});")
    Integer save(PostingSay postingSay);

    @Update("UPDATE `postingSay` SET say = #{say}, date = #{date}, user = #{user}, posting = #{posting} WHERE `id` = #{id}")
    Integer updateById(PostingSay postingSay);

    @Delete("DELETE FROM postingSay WHERE id = #{id}")
    Integer DeleteById(Long id);
}
