package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.headlinesLikeMapper;
import com.example.fzp.mapper.headlinesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class headlinesService implements headlinesMapper {
    @Resource
    headlinesMapper headlinesMapper;

    @Resource
    headlinesLikeMapper headlinesLikeMapper;

    @Override
    public List<Headlines> findAll() {
        return headlinesMapper.findAll();
    }

    @Override
    public List<Headlines> findAllIndex() {
        return null;
    }

    public Map findAllCode() {
        List<Headlines> cache = headlinesMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Headlines i: cache) {
            i.setLikeCOUNT(headlinesLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(headlinesLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findAllIndexCode() {
        List<Headlines> cache = headlinesMapper.findAllIndex();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Headlines i: cache) {
            i.setLikeCOUNT(headlinesLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(headlinesLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<Headlines> findById(Long id) {
        return headlinesMapper.findById(id);
    }

    @Override
    public List<Headlines> findByUserId(Long id) {
        return null;
    }




    public Map findByIdCode(Long id) {
        List<Headlines> cache = headlinesMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Headlines i: cache) {
            i.setLikeCOUNT(headlinesLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(headlinesLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByUserIdCode(Long id) {
        List<Headlines> cache = headlinesMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Headlines i: cache) {
            i.setLikeCOUNT(headlinesLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(headlinesLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }



    @Override
    public List<Headlines> findHeadlinesByPage(int page, int limit, String name, int userId) {
        return null;
    }

    public Map findHeadlinesByPageCode(int page, int limit, String name, int userId) {
        boolean bl = name.equals("-1")&&userId==-1;
        if (name.equals("-1"))
            name = null;
        else
            name = "%" + name + "%";
        page = (page-1)*limit;
        List<Headlines> cache = headlinesMapper.findHeadlinesByPage(page,limit,name,userId);
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
            map.put("count",headlinesMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer save(Headlines headlines) {
        return headlinesMapper.save(headlines);
    }

    public Map saveCode(Headlines headlines) {
        Integer cache = headlinesMapper.save(headlines);
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
    public Integer updateById(Headlines headlines) {
        return headlinesMapper.updateById(headlines);
    }

    public Map updateByIdCode(Headlines headlines) {
        Integer cache = headlinesMapper.updateById(headlines);
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
        return headlinesMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = headlinesMapper.DeleteById(id);
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
