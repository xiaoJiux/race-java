package com.example.fzp.mapper;

import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.Institute;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface instituteMapper {
    @Select("SELECT * FROM `institute`")
    List<Institute> findAll();

    @Select("SELECT * FROM `institute` WHERE id = #{id}")
    List<Institute> findById(Long id);

    @Insert("INSERT INTO `institute` (`institute`,`img`) VALUES (#{institute},#{img});")
    Integer save(Institute institute);

    @Update("UPDATE `institute` SET `institute` = #{institute}, `img` = #{img} WHERE `id` = #{id}")
    Integer updateById(Institute institute);

    @Delete("DELETE FROM institute WHERE id = #{id}")
    Integer DeleteById(Long id);
}
