package com.example.fzp.service;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.Join;
import com.example.fzp.mapper.headlinesLikeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class headlinesLikeService implements headlinesLikeMapper {
    @Resource
    headlinesLikeMapper headlinesLikeMapper;

    @Override
    public List<HeadlinesLike> findAll() {
        return headlinesLikeMapper.findAll();
    }

    public Map findAllCode() {
        List<HeadlinesLike> cache = headlinesLikeMapper.findAll();
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
    public List<HeadlinesLike> findById(Long id) {
        return headlinesLikeMapper.findById(id);
    }

    @Override
    public List<HeadlinesLike> findByLikeTypeId(Long id) {
        return null;
    }

    public Map findByLikeTypeIdCode(Long id) {
        List<HeadlinesLike> cache = headlinesLikeMapper.findByLikeTypeId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
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
        List<HeadlinesLike> cache = headlinesLikeMapper.findById(id);
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

    @Override
    public List<HeadlinesLike> findHeadlinesLikeByPage(int page, int limit, int headlinesId, int userId, int likeType) {
        return null;
    }

    @Override
    public Integer findByLikeType1COUNT(Long id) {
        return null;
    }

    @Override
    public Integer findByLikeType2COUNT(Long id) {
        return null;
    }

    public Map findHeadlinesLikeByPageCode(int page, int limit, int headlinesId, int userId, int likeType) {
        boolean bl = headlinesId==-1&&userId==-1&&likeType==-1;
        page = (page-1)*limit;
        List<HeadlinesLike> cache = headlinesLikeMapper.findHeadlinesLikeByPage(page,limit,headlinesId,userId,likeType);
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
            map.put("count",headlinesLikeMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer save(HeadlinesLike headlinesLike) {
        return headlinesLikeMapper.save(headlinesLike);
    }

    public Map saveCode(HeadlinesLike headlinesLike) {
        Integer cache = headlinesLikeMapper.save(headlinesLike);
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
    public Integer updateById(HeadlinesLike headlinesLike) {
        return headlinesLikeMapper.updateById(headlinesLike);
    }

    public Map updateByIdCode(HeadlinesLike headlinesLike) {
        Integer cache = headlinesLikeMapper.updateById(headlinesLike);
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
        return headlinesLikeMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = headlinesLikeMapper.DeleteById(id);
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
