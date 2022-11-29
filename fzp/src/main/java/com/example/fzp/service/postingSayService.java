package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.headlinesSayMapper;
import com.example.fzp.mapper.postingSayLikeMapper;
import com.example.fzp.mapper.postingSayMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class postingSayService implements postingSayMapper {
    @Resource
    postingSayMapper postingSayMapper;

    @Resource
    postingSayLikeMapper postingSayLikeMapper;

    @Override
    public List<PostingSay> findAll() {
        return postingSayMapper.findAll();
    }

    public Map findAllPostingSay() {
        List<PostingSay> cache = postingSayMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (PostingSay i: cache) {
            i.setLikeCOUNT(postingSayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<PostingSay> findById(Long id) {
        return postingSayMapper.findById(id);
    }

    @Override
    public List<PostingSay> findByUserId(Long id) {
        return postingSayMapper.findByUserId(id);
    }

    @Override
    public List<PostingSay> findByPostingId(Long id) {
        return null;
    }

    public Map findByUserIdCode(Long id) {
        List<PostingSay> cache = postingSayMapper.findByUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (PostingSay i: cache) {
            i.setLikeCOUNT(postingSayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<PostingSay> findPostingSayByPage(int page, int limit, int postingId, int userId) {
        return null;
    }

    public Map findPostingSayByPageCode(int page, int limit, int postingId, int userId) {
        boolean bl = postingId==-1&&userId==-1;
        page = (page-1)*limit;
        List<PostingSay> cache = postingSayMapper.findPostingSayByPage(page,limit,postingId,userId);
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
            map.put("count",postingSayMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer findBySayCOUNT(Long posting) {
        return null;
    }

    public Map findByIdCode(Long id) {
        List<PostingSay> cache = postingSayMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (PostingSay i: cache) {
            i.setLikeCOUNT(postingSayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    @Override
    public Integer save(PostingSay postingSay) {
        return postingSayMapper.save(postingSay);
    }

    public Map saveCode(PostingSay postingSay) {
        Integer cache = postingSayMapper.save(postingSay);
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
    public Integer updateById(PostingSay postingSay) {
        return postingSayMapper.updateById(postingSay);
    }

    public Map updateByIdCode(PostingSay postingSay) {
        Integer cache = postingSayMapper.updateById(postingSay);
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
        return postingSayMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = postingSayMapper.DeleteById(id);
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
