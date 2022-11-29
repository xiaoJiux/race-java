package com.example.fzp.mapper;

import com.example.fzp.entity.LikeType;
import com.example.fzp.entity.Opacity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface likeTypeMapper {

    @Select("SELECT * FROM `likeType`")
    List<LikeType> findAll();

    @Select("SELECT * FROM `likeType` WHERE id = #{id}")
    List<LikeType> findById(Long id);

    @Insert("INSERT INTO `likeType` (`likeType`) VALUES (#{likeType});")
    Integer save(LikeType likeType);

    @Update("UPDATE `likeType` SET `likeType` = #{likeType} WHERE `id` = #{id}")
    Integer updateById(LikeType likeType);

    @Delete("DELETE FROM `likeType` WHERE id = #{id}")
    Integer DeleteById(Long id);

}
