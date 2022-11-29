package com.example.fzp.mapper;

import com.example.fzp.entity.SignType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface signTypeMapper {
    @Select("SELECT * FROM `type`")
    List<SignType> findAll();

    @Select("SELECT * FROM `type` WHERE id = #{id}")
    List<SignType> findById(Long id);

    @Insert("INSERT INTO `type` (`type`) VALUES (#{type});")
    Integer save(SignType state);

    @Update("UPDATE `type` SET `type` = #{type} WHERE `id` = #{id}")
    Integer updateById(SignType type);

    @Delete("DELETE FROM `type` WHERE id = #{id}")
    Integer DeleteById(Long id);
}
