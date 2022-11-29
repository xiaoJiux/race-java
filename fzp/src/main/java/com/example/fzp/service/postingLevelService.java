package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.opacityMapper;
import com.example.fzp.mapper.postingLevelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class postingLevelService implements postingLevelMapper{
    @Resource
    postingLevelMapper postingLevelMapper;

    @Override
    public List<PostingLevel> findAll() {
        return postingLevelMapper.findAll();
    }

    public Map findAllPostingLevel() {
        List<PostingLevel> cache = postingLevelMapper.findAll();
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
    public List<PostingLevel> findById(Long id) {
        return postingLevelMapper.findById(id);
    }

    public Map findByIdCode(Long id) {
        List<PostingLevel> cache = postingLevelMapper.findById(id);
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
    public Integer save(PostingLevel postingLevel) {
        return postingLevelMapper.save(postingLevel);
    }

    public Map saveCode(PostingLevel postingLevel) {
        Integer cache = postingLevelMapper.save(postingLevel);
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
    public Integer updateById(PostingLevel postingLevel) {
        return postingLevelMapper.updateById(postingLevel);
    }

    public Map updateByIdCode(PostingLevel postingLevel) {
        Integer cache = postingLevelMapper.updateById(postingLevel);
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
        return postingLevelMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = postingLevelMapper.DeleteById(id);
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
