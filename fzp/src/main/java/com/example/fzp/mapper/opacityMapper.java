package com.example.fzp.mapper;

import com.example.fzp.entity.Opacity;
import com.example.fzp.entity.Points;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface opacityMapper {
    @Select("SELECT * FROM `opacity`")
    List<Opacity> findAll();

    @Select("SELECT * FROM `opacity` WHERE id = #{id}")
    List<Opacity> findById(Long id);

    @Insert("INSERT INTO `opacity` (`opacity`) VALUES (#{opacity});")
    Integer save(Opacity opacity);

    @Update("UPDATE `opacity` SET `opacity` = #{opacity} WHERE `id` = #{id}")
    Integer updateById(Opacity opacity);

    @Delete("DELETE FROM `opacity` WHERE id = #{id}")
    Integer DeleteById(Long id);
}
