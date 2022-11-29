package com.example.fzp.service;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.mapper.headlinesSayLikeMapper;
import com.example.fzp.mapper.headlinesSayMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class headlinesSayLikeService implements headlinesSayLikeMapper {
    @Resource
    headlinesSayLikeMapper headlinesSayLikeMapper;

    @Override
    public List<HeadlinesSayLike> findAll() {
        return headlinesSayLikeMapper.findAll();
    }

    public Map findAllCode() {
        List<HeadlinesSayLike> cache = headlinesSayLikeMapper.findAll();
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
    public List<HeadlinesSayLike> findById(Long id) {
        return headlinesSayLikeMapper.findById(id);
    }



    public Map findByIdCode(Long id) {
        List<HeadlinesSayLike> cache = headlinesSayLikeMapper.findById(id);
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
    public List<HeadlinesSayLike> findHeadlinesSayLikeByPage(int page, int limit, int headlinesSayId, int userId) {
        return null;
    }

    @Override
    public Integer findByLikeType1COUNT(Long id) {
        return null;
    }


    public Map findHeadlinesSayLikeByPageCode(int page, int limit, int headlinesSayId, int userId) {
        boolean bl = headlinesSayId==-1&&userId==-1;
        page = (page-1)*limit;
        List<HeadlinesSayLike> cache = headlinesSayLikeMapper.findHeadlinesSayLikeByPage(page,limit,headlinesSayId,userId);
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
            map.put("count",headlinesSayLikeMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer save(HeadlinesSayLike headlinesSayLike) {
        return headlinesSayLikeMapper.save(headlinesSayLike);
    }

    public Map saveCode(HeadlinesSayLike headlinesSayLike) {
        Integer cache = headlinesSayLikeMapper.save(headlinesSayLike);
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
    public Integer updateById(HeadlinesSayLike headlinesSayLike) {
        return headlinesSayLikeMapper.updateById(headlinesSayLike);
    }

    public Map updateByIdCode(HeadlinesSayLike headlinesSayLike) {
        Integer cache = headlinesSayLikeMapper.updateById(headlinesSayLike);
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
        return headlinesSayLikeMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = headlinesSayLikeMapper.DeleteById(id);
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
