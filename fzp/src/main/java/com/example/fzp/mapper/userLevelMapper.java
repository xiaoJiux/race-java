package com.example.fzp.mapper;

import com.example.fzp.entity.Sex;
import com.example.fzp.entity.userLevel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userLevelMapper {
    @Select("SELECT * FROM userLevel")
    List<userLevel> findAll();

    @Select("SELECT * FROM `userLevel` WHERE id = #{id}")
    List<userLevel> findById(Long id);

    @Insert("INSERT INTO `userLevel` (`level`) VALUES (#{level});")
    Integer save(userLevel userLevel);

    @Update("UPDATE `userLevel` SET level = #{level} WHERE `id` = #{id}")
    Integer updateById(userLevel userLevel);

    @Delete("DELETE FROM userLevel WHERE id = #{id}")
    Integer DeleteById(Long id);
}
