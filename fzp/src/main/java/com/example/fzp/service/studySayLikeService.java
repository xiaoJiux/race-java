package com.example.fzp.service;

import com.example.fzp.entity.StudyLike;
import com.example.fzp.entity.StudySay;
import com.example.fzp.entity.StudySayLike;
import com.example.fzp.mapper.studyLikeMapper;
import com.example.fzp.mapper.studySayLikeMapper;
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
public class studySayLikeService {

    @Resource
    studySayLikeMapper studySayLikeMapper;

    public Map findAllCode() {
        List<StudySayLike> cache = studySayLikeMapper.findAll();
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
        List<StudySayLike> cache = studySayLikeMapper.findById(id);
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

    public Map findByPage(int page, int limit, int studySayId, int userId) {
        boolean bl = studySayId==-1&&userId==-1;
        page = (page-1)*limit;
        List<StudySayLike> cache = studySayLikeMapper.findByPage(page,limit, studySayId, userId);
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
            map.put("count",studySayLikeMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map saveCode(StudySayLike studySayLike) {
        Integer cache = studySayLikeMapper.save(studySayLike);
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


    public Map updateByIdCode(StudySayLike studySayLike) {
        Integer cache = studySayLikeMapper.updateById(studySayLike);
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
        Integer cache = studySayLikeMapper.DeleteById(id);
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
