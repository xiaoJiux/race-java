package com.example.fzp.service;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.entity.PostingLevel;
import com.example.fzp.entity.PostingSayLike;
import com.example.fzp.mapper.headlinesSayLikeMapper;
import com.example.fzp.mapper.postingSayLikeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class postingSayLikeService implements postingSayLikeMapper {
    @Resource
    postingSayLikeMapper postingSayLikeMapper;

    @Override
    public List<PostingSayLike> findAll() {
        return postingSayLikeMapper.findAll();
    }

    public Map findAllPostingSayLike() {
        List<PostingSayLike> cache = postingSayLikeMapper.findAll();
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
    public List<PostingSayLike> findById(Long id) {
        return postingSayLikeMapper.findById(id);
    }


    @Override
    public List<PostingSayLike> findPostingSayLikeByPage(int page, int limit, int postingSayId, int userId) {
        return null;
    }

    @Override
    public Integer findByLikeType1COUNT(Long id) {
        return null;
    }

    public Map findPostingSayLikeByPageCode(int page, int limit, int postingSayId, int userId) {
        boolean bl = postingSayId==-1&&userId==-1;
        page = (page-1)*limit;
        List<PostingSayLike> cache = postingSayLikeMapper.findPostingSayLikeByPage(page,limit,postingSayId,userId);
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
            map.put("count",postingSayLikeMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByIdCode(Long id) {
        List<PostingSayLike> cache = postingSayLikeMapper.findById(id);
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
    public Integer save(PostingSayLike postingSayLike) {
        return postingSayLikeMapper.save(postingSayLike);
    }

    public Map saveCode(PostingSayLike postingSayLike) {
        Integer cache = postingSayLikeMapper.save(postingSayLike);
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
    public Integer updateById(PostingSayLike postingSayLike) {
        return postingSayLikeMapper.updateById(postingSayLike);
    }

    public Map updateByIdCode(PostingSayLike postingSayLike) {
        Integer cache = postingSayLikeMapper.updateById(postingSayLike);
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
        return postingSayLikeMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = postingSayLikeMapper.DeleteById(id);
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
