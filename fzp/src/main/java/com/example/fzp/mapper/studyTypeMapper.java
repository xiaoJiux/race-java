package com.example.fzp.mapper;

import com.example.fzp.entity.StudyType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studyTypeMapper {
    @Select("SELECT * FROM studyType")
    List<StudyType> findAll();

    @Select("SELECT * FROM `studyType` WHERE id = #{id}")
    List<StudyType> findById(Long id);

    @Insert("INSERT INTO `studyType` (`type`) VALUES (#{type});")
    Integer save(StudyType studyType);

    @Update("UPDATE `studyType` SET type = #{type} WHERE `id` = #{id}")
    Integer updateById(StudyType studyType);

    @Delete("DELETE FROM studyType WHERE id = #{id}")
    Integer DeleteById(Long id);
}
