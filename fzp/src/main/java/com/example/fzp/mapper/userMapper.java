package com.example.fzp.mapper;

import com.example.fzp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {
    @Select("SELECT *, s.sex sexString, l.`level` levelString, i.institute instituteString FROM `user` u LEFT JOIN `sex` s ON u.sex = s.id LEFT JOIN userlevel l ON l.`id` = u.`level` LEFT JOIN institute i ON i.id = u.institute")
    List<User> findAll();

    @Select("SELECT *, s.sex sexString, l.`level` levelString, i.institute instituteString FROM `user` u LEFT JOIN `sex` s ON u.sex = s.id LEFT JOIN userlevel l ON l.`id` = u.`level` LEFT JOIN institute i ON i.id = u.institute WHERE u.id = #{id}")
    List<User> findUserById(Long id);

    @Select({"<script>"
            +"SELECT *, s.sex sexString, i.institute instituteString, l.`level` levelString FROM `user` u LEFT JOIN sex s ON s.id = u.sex LEFT JOIN institute i ON i.id = u.institute LEFT JOIN userlevel l ON l.id = u.level "
            +" where 1=1"
            +"<when test= 'number != null'> and number=#{number} </when>"
            +"<when test= 'name != null'> and name=#{name} </when>"
            +"<when test= 'mail != null'> and mail= #{mail} </when>"
            +"<when test= 'sexId != -1'> and u.sex=#{sexId} </when>"
            +"<when test= 'instituteId != -1'> and u.institute=#{instituteId} </when>"
            +"<when test= 'levelId != -1'> and u.level=#{levelId} </when>"
            +"LIMIT #{page},#{limit}"
            +"</script>"})
    List<User> findUserByPage(@Param("page") int page,@Param("limit") int limit,@Param("number") String number,@Param("name") String name,@Param("mail") String mail,@Param("sexId") int sexId,@Param("instituteId") int instituteId,@Param("levelId") int levelId);

    @Select("SELECT * FROM `user` WHERE name = #{name}")
    List<User> findUserByName(String name);

    @Select("SELECT *, s.sex sexString, l.`level` levelString, i.institute instituteString FROM `user` u LEFT JOIN `sex` s ON u.sex = s.id LEFT JOIN userlevel l ON l.`id` = u.`level` LEFT JOIN institute i ON i.id = u.institute WHERE number = #{name} AND password = #{password}")
    List<User> findUserByNameAndPassword(String name,String password);

    @Insert("INSERT INTO `user` (`number`, `password`, `name`, introduce, birthday, phone, mail, img, sex, level, institute) VALUES (#{number},#{password}, #{name}, #{introduce}, #{birthday}, #{phone}, #{mail}, #{img}, #{sex}, #{level}, #{institute});")
    Integer save(User user);

    @Update("UPDATE `user` SET number = #{number}, password = #{password}, name = #{name}, introduce = #{introduce}, birthday = #{birthday}, phone = #{phone}, mail = #{mail}, img = #{img}, sex = #{sex}, level = #{level}, institute = #{institute} WHERE `id` = #{id}")
    Integer updateById(User user);

    @Delete("DELETE FROM `fzp`.`user` WHERE `id` = #{id}")
    Integer DeleteById(Long id);
}
