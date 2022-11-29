package com.example.fzp.service;

import com.example.fzp.entity.*;
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
public class headlinesSayService implements headlinesSayMapper {
    @Resource
    headlinesSayMapper headlinesSayMapper;

    @Resource
    headlinesSayLikeMapper headlinesSayLikeMapper;

    @Override
    public List<HeadlinesSay> findAll() {
        return headlinesSayMapper.findAll();
    }

    public Map findAllCode() {
        List<HeadlinesSay> cache = headlinesSayMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (HeadlinesSay i: cache) {
            i.setLikeCOUNT(headlinesSayLikeMapper.findByLikeType1COUNT((long) i.getId()));

        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<HeadlinesSay> findById(Long id) {
        return headlinesSayMapper.findById(id);
    }

    @Override
    public List<HeadlinesSay> findByUserId(Long id) {
        return headlinesSayMapper.findByUserId(id);
    }

    @Override
    public List<HeadlinesSay> findByHeadlinesId(Long id) {
        return null;
    }

    public Map findByUserIdCode(Long id) {
        List<HeadlinesSay> cache = headlinesSayMapper.findByUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (HeadlinesSay i: cache) {
            i.setLikeCOUNT(headlinesSayLikeMapper.findByLikeType1COUNT((long) i.getId()));

        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByHeadlinesIdCode(Long id) {
        List<HeadlinesSay> cache = headlinesSayMapper.findByHeadlinesId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (HeadlinesSay i: cache) {
            i.setLikeCOUNT(headlinesSayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByIdCode(Long id) {
        List<HeadlinesSay> cache = headlinesSayMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (HeadlinesSay i: cache) {
            i.setLikeCOUNT(headlinesSayLikeMapper.findByLikeType1COUNT((long) i.getId()));

        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    @Override
    public List<HeadlinesSay> findHeadlinesSayByPage(int page, int limit, int headlines, int userId) {
        return null;
    }

    public Map findHeadlinesSayByPageCode(int page, int limit, int headlines, int userId) {
        boolean bl = headlines==-1&&userId==-1;
        page = (page-1)*limit;
        List<HeadlinesSay> cache = headlinesSayMapper.findHeadlinesSayByPage(page,limit,headlines,userId);
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
            map.put("count",headlinesSayMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer save(HeadlinesSay headlinesSay) {
        return headlinesSayMapper.save(headlinesSay);
    }

    public Map saveCode(HeadlinesSay headlinesSay) {
        Integer cache = headlinesSayMapper.save(headlinesSay);
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
    public Integer updateById(HeadlinesSay headlinesSay) {
        return headlinesSayMapper.updateById(headlinesSay);
    }

    public Map updateByIdCode(HeadlinesSay headlinesSay) {
        Integer cache = headlinesSayMapper.updateById(headlinesSay);
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
        return headlinesSayMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = headlinesSayMapper.DeleteById(id);
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
