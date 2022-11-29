package com.example.fzp.mapper;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.Join;
import com.example.fzp.entity.Sign;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface joinMapper {
    @Select("SELECT * FROM fzp.join")
    List<Join> findAll();

    @Select("SELECT * FROM `join` WHERE id = #{id}")
    List<Join> findById(Long id);

    @Select("SELECT * FROM `join` WHERE user = #{userId}")
    List<Join> findByUserId(Long userId);

    @Select("SELECT COUNT(id) `person` FROM `join` WHERE activity = #{activityId}")
    Integer findActivityCOUNT(Long activityId);

    @Select("SELECT *, u.`name` userName, u.img userImg,inst.institute userInstitute, a.`name` activityName, a.img activityImg, ex.examine examineString FROM `join` s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `activity` a ON s.`activity` = a.id LEFT JOIN examine ex ON s.examine = ex.id LEFT JOIN institute inst ON u.institute = inst.id WHERE s.activity = #{activityId} AND s.examine = 1")
    List<Join> findActivityJoin(Long activityId);

    @Select("SELECT *, u.`name` userName, u.img userImg,inst.institute userInstitute, a.`name` activityName, a.img activityImg, ex.examine examineString FROM `join` s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `activity` a ON s.`activity` = a.id LEFT JOIN examine ex ON s.examine = ex.id LEFT JOIN institute inst ON u.institute = inst.id WHERE s.activity = #{activityId} AND s.examine = 2")
    List<Join> findActivityJoinPass(Long activityId);

    @Select("SELECT *, u.`name` userName, u.img userImg,inst.institute userInstitute, a.`name` activityName, a.img activityImg, ex.examine examineString FROM `join` s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `activity` a ON s.`activity` = a.id LEFT JOIN examine ex ON s.examine = ex.id LEFT JOIN institute inst ON u.institute = inst.id WHERE s.activity = #{activityId} AND s.examine = 3")
    List<Join> findActivityJoinFailed(Long activityId);

    @Select({"<script>"
            +"SELECT *, u.`name` userName, u.img userImg, a.`name` activityName, a.img activityImg FROM `join` s LEFT JOIN `user` u ON s.`user` = u.id LEFT JOIN `activity` a ON s.`activity` = a.id"
            +" WHERE 1=1 "
            +"<when test= 'activityId != -1'> and s.`activity`= #{activityId} </when>"
            +"<when test= 'userId != -1'> and s.`user`= #{userId} </when>"
            +" LIMIT #{page},#{limit}"
            +"</script>"})
    List<Join> findByPage(@Param("page") int page, @Param("limit") int limit, @Param("activityId") int activityId, @Param("userId") int userId);


    @Insert("INSERT INTO `join` (`user`, `activity`) VALUES (#{user}, #{activity});")
    Integer save(Join join);

    @Update("UPDATE `join` SET user = #{user}, activity = #{activity} WHERE `id` = #{id}")
    Integer updateById(Join join);

    @Update("UPDATE `join` SET examine = 2 WHERE `id` = #{id}")
    Integer updateExamineById(Long id);

    @Update("UPDATE `join` SET examine = 3 WHERE `id` = #{id}")
    Integer updateExamine3ById(Long id);

    @Delete("DELETE FROM `fzp`.join WHERE id = #{id}")
    Integer DeleteById(Long id);
}
