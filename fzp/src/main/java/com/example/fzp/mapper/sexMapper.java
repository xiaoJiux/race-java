package com.example.fzp.mapper;

import com.example.fzp.entity.PostingSay;
import com.example.fzp.entity.Sex;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface sexMapper {
    @Select("SELECT * FROM sex")
    List<Sex> findAll();

    @Select("SELECT * FROM `sex` WHERE id = #{id}")
    List<Sex> findById(Long id);

    @Insert("INSERT INTO `sex` (`sex`) VALUES (#{sex});")
    Integer save(Sex sex);

    @Update("UPDATE `sex` SET sex = #{sex} WHERE `id` = #{id}")
    Integer updateById(Sex sex);

    @Delete("DELETE FROM sex WHERE id = #{id}")
    Integer DeleteById(Long id);
}
