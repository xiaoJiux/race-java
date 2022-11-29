package com.example.fzp.mapper;

import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.entity.PostingSayLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface postingSayLikeMapper {
    @Select("SELECT * FROM postingSayLike")
    List<PostingSayLike> findAll();

    @Select("SELECT * FROM `postingSayLike` WHERE id = #{id}")
    List<PostingSayLike> findById(Long id);

    @Select({"<script>"
            +"SELECT *, line.`name` postingName, line.img postingImg, u1.`name` likeUserName, u1.img likeUserImg, u2.`name` sayUserName, u2.img sayUserImg, hs.say sayContent FROM postingSayLike h LEFT JOIN `user` u1 ON h.`user` = u1.id LEFT JOIN `postingSay` hs ON h.`postingSay` = hs.id LEFT JOIN `user` u2 ON hs.`user` = u2.id LEFT JOIN `posting` line ON hs.posting = line.id"
            +" where 1=1"
            +"<when test= 'postingSayId != -1'> and h.`postingSay`= #{postingSayId} </when>"
            +"<when test= 'userId != -1'> and h.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<PostingSayLike> findPostingSayLikeByPage(@Param("page") int page, @Param("limit") int limit, @Param("postingSayId") int postingSayId, @Param("userId") int userId);

    @Select("SELECT COUNT(id) COUNTLike FROM postingSayLike WHERE postingSay = #{id} ")
    Integer findByLikeType1COUNT(Long id);

    @Insert("INSERT INTO `postingSayLike` (`user`, `postingSay`) VALUES (#{user}, #{postingSay});")
    Integer save(PostingSayLike postingSayLike);

    @Update("UPDATE `postingSayLike` SET user = #{user}, postingSay = #{postingSay} WHERE `id` = #{id}")
    Integer updateById(PostingSayLike postingSayLike);

    @Delete("DELETE FROM postingSayLike WHERE id = #{id}")
    Integer DeleteById(Long id);
}
