package com.example.fzp.mapper;

import com.example.fzp.entity.Clock;
import com.example.fzp.entity.In;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface clockMapper {
    @Select("SELECT * FROM `clock`")
    List<Clock> findAll();

    @Select("SELECT * FROM `clock` WHERE user = #{id}")
    List<Clock> findById(Long id);

    @Select("SELECT COUNT(id) CountClock FROM `clock`  WHERE user = #{id}")
    Integer findByClockDayForUser(Long id);

    @Select("SELECT * FROM `clock` WHERE date = #{date} AND user = #{id}")
    List<Clock> findByDateAndUserId(Date date,Long id);

    @Insert("INSERT INTO `clock` (`date`, `user`) VALUES (#{date},#{user});")
    Integer save(Clock clock);

    @Update("UPDATE `clock` SET `date` = #{date}, `user` = #{user} WHERE `id` = #{id}")
    Integer updateById(Clock clock);

    @Delete("DELETE FROM `clock` WHERE id = #{id}")
    Integer DeleteById(Long id);
}
