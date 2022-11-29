package com.example.fzp.mapper;

import com.example.fzp.entity.Points;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface pointsMapper {
    @Select("SELECT *,us1.`name` userName,us1.img userImg,ins.institute userInstitute , us2.`name` addName, SUM(p.number) sumNumber FROM points p LEFT JOIN `user` us1 ON p.`user` = us1.id LEFT JOIN `user` us2 ON p.`add` = us2.id LEFT JOIN `institute` ins ON us1.`institute` = ins.id LEFT JOIN pointsType pt ON p.`type` = pt.id  GROUP BY p.`user` ")
    List<Points> findAll();

    @Select("SELECT *,COUNT(id) COUNTID FROM points p WHERE  p.`user` = #{userId} GROUP BY type")
    List<Points> findTypeCOUNT(Long userId);

    @Select("SELECT *,us1.`name` userName,us1.img userImg,ins.institute userInstitute , us2.`name` addName, SUM(p.number) sumNumber FROM points p LEFT JOIN `user` us1 ON p.`user` = us1.id LEFT JOIN `user` us2 ON p.`add` = us2.id LEFT JOIN `institute` ins ON us1.`institute` = ins.id LEFT JOIN pointsType pt ON p.`type` = pt.id  GROUP BY p.`user` ORDER BY sumNumber DESC LIMIT 3")
    List<Points> findAllSumPointsLimit3();


    @Select("SELECT *, us1.`name` userName, us1.img userImg, ins.institute userInstitute, ins.img instituteImg, us2.`name` addName, SUM( p.number ) sumNumber FROM points p LEFT JOIN `user` us1 ON p.`user` = us1.id LEFT JOIN `user` us2 ON p.`add` = us2.id LEFT JOIN `institute` ins ON us1.`institute` = ins.id LEFT JOIN pointsType pt ON p.`type` = pt.id GROUP BY us1.institute ORDER BY sumNumber DESC LIMIT 3")
    List<Points> findAllSumPointsInsLimit3();

    @Select("SELECT *,us1.`name` userName,us1.img userImg,ins.institute userInstitute , us2.`name` addName, SUM(p.number) sumNumber FROM points p LEFT JOIN `user` us1 ON p.`user` = us1.id LEFT JOIN `user` us2 ON p.`add` = us2.id LEFT JOIN `institute` ins ON us1.`institute` = ins.id LEFT JOIN pointsType pt ON p.`type` = pt.id  GROUP BY p.`user` HAVING p.`user` = #{id} ")
    List<Points> findById(Long id);

    @Select("SELECT *,us1.`name` userName,us1.img userImg,ins.institute userInstitute , us2.`name` addName FROM points p LEFT JOIN `user` us1 ON p.`user` = us1.id LEFT JOIN `user` us2 ON p.`add` = us2.id LEFT JOIN `institute` ins ON us1.`institute` = ins.id LEFT JOIN pointsType pt ON p.`type` = pt.id WHERE p.`user` = #{id} ")
    List<Points> findByUserId(Long id);

    @Select({"<script>"
            +"SELECT *, us2.`name` addName, us1.`number` numId FROM points p LEFT JOIN `user` us1 ON p.`user` = us1.id LEFT JOIN `user` us2 ON p.`add` = us2.id"
            +" where 1=1"
            +"<when test= 'name != null'> and us1.`name`= #{name} </when>"
            +"<when test= 'info != null'> and info LIKE #{info} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<Points> findPointsByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name, @Param("info") String info);


    @Insert("INSERT INTO `points` (`number`, `info`, `user`, `add`) VALUES (#{number}, #{info}, #{user}, #{add});")
    Integer save(Points points);

    @Update("UPDATE `fzp`.`points` SET `number` = #{number}, `info` = #{info}, `user` = #{user}, `add` = #{add} WHERE `id` = #{id}")
    Integer updateById(Points points);

    @Update("INSERT INTO `points` (`number`, `info`, `user`) VALUES (#{points}, #{info}, #{id} )")
    Integer reducePoints(Long id, Long points, String info);

    @Delete("DELETE FROM points WHERE id = #{id}")
    Integer DeleteById(Long id);
}
