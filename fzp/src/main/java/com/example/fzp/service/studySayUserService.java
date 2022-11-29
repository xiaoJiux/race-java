package com.example.fzp.service;

import com.example.fzp.entity.Sign;
import com.example.fzp.entity.StudySay;
import com.example.fzp.entity.StudySayUser;
import com.example.fzp.mapper.studySayUserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class studySayUserService {
    @Resource
    studySayUserMapper studySayUserMapper;

    public Map findAllCode() {
        List<StudySayUser> cache = studySayUserMapper.findAll();
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


    public Map findByIdCode(Long id) {
        List<StudySayUser> cache = studySayUserMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findSignByPage(int page, int limit, int byUserId, int userId) {
        boolean bl = byUserId==-1&&userId==-1;
        page = (page-1)*limit;
        List<StudySayUser> cache = studySayUserMapper.findByPage(page,limit,byUserId,userId);
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
            map.put("count",studySayUserMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map saveCode(StudySayUser studySayUser) {
        Integer cache = studySayUserMapper.save(studySayUser);
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


    public Map updateByIdCode(StudySayUser studySayUser) {
        Integer cache = studySayUserMapper.updateById(studySayUser);
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


    public Map DeleteByIdCode(Long id) {
        Integer cache = studySayUserMapper.DeleteById(id);
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
}
