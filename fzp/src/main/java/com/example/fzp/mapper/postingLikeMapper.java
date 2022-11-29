package com.example.fzp.mapper;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.Posting;
import com.example.fzp.entity.PostingLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface postingLikeMapper {
    @Select("SELECT * FROM postingLike")
    List<PostingLike> findAll();

    @Select("SELECT * FROM `postingLike` WHERE id = #{id}")
    List<PostingLike> findById(Long id);

    @Select("SELECT *, u.img userImg, u.`name` userName, p.`name` postingName, p.img postingImg, p.content postingContent FROM postinglike pk LEFT JOIN `user` u ON pk.`user` = u.id LEFT JOIN `posting` p ON pk.`posting` = p.id WHERE pk.user = #{id} AND pk.likeType = 2")
    List<PostingLike> findByLikeTypeId(Long id);

    @Select("SELECT COUNT(id) likeCOUNT FROM `postingLike` WHERE posting = #{posting}")
    Integer findByLikeCOUNT(Long posting);

    @Select({"<script>"
            +"SELECT *, u.img userImg, u.`name` userName, p.`name` postingName, p.img postingImg FROM postinglike pk LEFT JOIN `user` u ON pk.`user` = u.id LEFT JOIN `posting` p ON pk.`posting` = p.id"
            +" where 1=1"
            +"<when test= 'postingId != -1'> and pk.`posting`= #{postingId} </when>"
            +"<when test= 'userId != -1'> and pk.`user`= #{userId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<PostingLike> findPostingLikeByPage(@Param("page") int page, @Param("limit") int limit, @Param("postingId") int postingId, @Param("userId") int userId);


    @Insert("INSERT INTO `postingLike` (`user`, `posting`, `likeType`) VALUES (#{user}, #{posting}, #{likeType});")
    Integer save(PostingLike postingLike);

    @Update("UPDATE `postingLike` SET user = #{user}, posting = #{posting}, likeType = #{likeType} WHERE `id` = #{id}")
    Integer updateById(PostingLike postingLike);

    @Delete("DELETE FROM postingLike WHERE id = #{id}")
    Integer DeleteById(Long id);

}
