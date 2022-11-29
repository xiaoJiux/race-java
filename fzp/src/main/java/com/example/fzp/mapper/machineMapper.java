package com.example.fzp.mapper;

import com.example.fzp.entity.Machine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface machineMapper {

    @Select("SELECT * FROM `machine` WHERE id = #{keyword} ")
    List<Machine> findKeyAll(String key);

    @Select("SELECT * FROM `machine` LIMIT 9")
    List<Machine> findAll();

    @Select("SELECT * FROM `machine` WHERE #{key} LIKE CONCAT('%',keyword,'%') ")
    List<Machine> findMachine(String key);


}
