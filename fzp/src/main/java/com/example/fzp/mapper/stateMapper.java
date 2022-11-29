package com.example.fzp.mapper;

import com.example.fzp.entity.In;
import com.example.fzp.entity.State;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface stateMapper {

    @Select("SELECT * FROM `state`")
    List<State> findAll();

    @Select("SELECT * FROM `state` WHERE id = #{id}")
    List<State> findById(Long id);

    @Insert("INSERT INTO `state` (`state`) VALUES (#{state});")
    Integer save(State state);

    @Update("UPDATE `state` SET `state` = #{state} WHERE `id` = #{id}")
    Integer updateById(State state);

    @Delete("DELETE FROM `state` WHERE id = #{id}")
    Integer DeleteById(Long id);
}
