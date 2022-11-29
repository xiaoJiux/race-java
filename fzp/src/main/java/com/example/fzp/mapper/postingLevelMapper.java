package com.example.fzp.mapper;

import com.example.fzp.entity.Points;
import com.example.fzp.entity.PostingLevel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface postingLevelMapper {
    @Select("SELECT * FROM `postingLevel`")
    List<PostingLevel> findAll();

    @Select("SELECT * FROM `postingLevel` WHERE id = #{id}")
    List<PostingLevel> findById(Long id);

    @Insert("INSERT INTO `postingLevel` (`level`) VALUES (#{level});")
    Integer save(PostingLevel postingLevel);

    @Update("UPDATE `postingLevel` SET `level` = #{level} WHERE `id` = #{id}")
    Integer updateById(PostingLevel postingLevel);

    @Delete("DELETE FROM `postingLevel` WHERE id = #{id}")
    Integer DeleteById(Long id);
}
