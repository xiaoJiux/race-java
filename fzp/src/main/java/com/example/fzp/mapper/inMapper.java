package com.example.fzp.mapper;

import com.example.fzp.entity.In;
import com.example.fzp.entity.Opacity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface inMapper {

    @Select("SELECT * FROM `in`")
    List<In> findAll();

    @Select("SELECT * FROM `in` WHERE id = #{id}")
    List<In> findById(Long id);

    @Insert("INSERT INTO `in` (`in`) VALUES (#{in});")
    Integer save(In in);

    @Update("UPDATE `in` SET `in` = #{in} WHERE `id` = #{id}")
    Integer updateById(In in);

    @Delete("DELETE FROM `in` WHERE id = #{id}")
    Integer DeleteById(Long id);
}
