package com.example.fzp.service;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.entity.PostingLevel;
import com.example.fzp.entity.User;
import com.example.fzp.mapper.userMapper;
import com.example.fzp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class userService implements userMapper{
    @Autowired
    TokenUtil tokenUtil;
    @Resource
    private userMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    public Map findUserByPages(int page, int limit, String number,String name,String mail,int sexId,int instituteId,int levelId) {
        boolean bl = number.equals("-1")&&name.equals("-1")&&mail.equals("-1")&&sexId==-1&&instituteId==-1&&levelId==-1;
        if (number.equals("-1")) number = null;
        if (name.equals("-1")) name = null;
        if (mail.equals("-1")) mail = null;
        page = (page-1)*limit;
        List<User> cache = userMapper.findUserByPage(page, limit, number, name, mail, sexId, instituteId,levelId);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        if (bl)
            map.put("count",userMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findAllUser() {
        List<User> cache = userMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<User> findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    public Map findByIdCode(Long id) {
        List<User> cache = userMapper.findUserById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        map.put("count",cache);
        return map;

    }

    @Override
    public List<User> findUserByPage(int page, int limit, String number,String name,String mail,int sexId,int instituteId,int levelId) {
        return null;
    }

    @Override
    public List<User> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    public Map findUserByNames(String name) {
        List<User> cache = userMapper.findUserByName(name);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<User> findUserByNameAndPassword(String name, String password) {
        return userMapper.findUserByNameAndPassword(name,password);
    }


    public Map findUserByNameAndPasswordAndToken(String name, String password) {
        if (CollectionUtils.isEmpty(userMapper.findUserByNameAndPassword(name,password))){
            Map map = new HashMap<>();
            map.put("code",-10000);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("message","查询成功");
        map.put("token",login());
        map.put("data",userMapper.findUserByNameAndPassword(name,password));
        return map;
    }

    @Override
    public Integer save(User user) {
        return userMapper.save(user);
    }

    public Map saveCode(User user) {
        Integer cache = userMapper.save(user);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","新增失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","新增成功");
        map.put("count",cache);
        return map;
    }

    @Override
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    public Map updateByIdCode(User user) {
        Integer cache = userMapper.updateById(user);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","更新失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","更新成功");
        map.put("count",cache);
        return map;

    }

    @Override
    public Integer DeleteById(Long id) {
        return userMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
//        System.out.println(id);
        Integer cache = userMapper.DeleteById(id);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","删除失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","删除成功");
        map.put("count",cache);
        return map;
    }

    public Map login(){

        Map map1= new HashMap<>();
        map1.put("token",tokenUtil.getToken("靓仔","admin"));
        return map1;
    }
}
