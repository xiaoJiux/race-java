package com.example.fzp.service;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.Join;
import com.example.fzp.entity.StudyLike;
import com.example.fzp.mapper.headlinesLikeMapper;
import com.example.fzp.mapper.studyLikeMapper;
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
public class studyLikeService {
    @Resource
    studyLikeMapper studyLikeMapper;

    public Map findAllCode() {
        List<StudyLike> cache = studyLikeMapper.findAll();
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
        List<StudyLike> cache = studyLikeMapper.findById(id);
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

    public Map findByLikeTypeId(Long id) {
        List<StudyLike> cache = studyLikeMapper.findByLikeTypeId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByPageCode(int page, int limit, int studyId, int likeType, int userId) {
        boolean bl = studyId==-1&&likeType==-1&&userId==-1;
        page = (page-1)*limit;
        List<StudyLike> cache = studyLikeMapper.findByPage(page,limit, studyId,likeType,userId);
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
            map.put("count",studyLikeMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map saveCode(StudyLike studyLike) {
        Integer cache = studyLikeMapper.save(studyLike);
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


    public Map updateByIdCode(StudyLike studyLike) {
        Integer cache = studyLikeMapper.updateById(studyLike);
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
        Integer cache = studyLikeMapper.DeleteById(id);
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
