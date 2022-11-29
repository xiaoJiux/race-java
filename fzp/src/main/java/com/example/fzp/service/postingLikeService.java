package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.headlinesLikeMapper;
import com.example.fzp.mapper.postingLikeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class postingLikeService implements postingLikeMapper {
    @Resource
    postingLikeMapper postingLikeMapper;

    @Override
    public List<PostingLike> findAll() {
        return postingLikeMapper.findAll();
    }

    public Map findAllPostingLike() {
        List<PostingLike> cache = postingLikeMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
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
    public List<PostingLike> findById(Long id) {
        return postingLikeMapper.findById(id);
    }

    @Override
    public List<PostingLike> findByLikeTypeId(Long id) {
        return null;
    }

    public Map findByLikeTypeIdCode(Long id) {
        List<PostingLike> cache = postingLikeMapper.findByLikeTypeId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
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
    public Integer findByLikeCOUNT(Long posting) {
        return null;
    }


    public Map findByIdCode(Long id) {
        List<PostingLike> cache = postingLikeMapper.findById(id);
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
    public List<PostingLike> findPostingLikeByPage(int page, int limit, int postingId, int userId) {
        return null;
    }

    public Map findPostingLikeByPageCode(int page, int limit, int postingId, int userId) {
        boolean bl = postingId==-1&&userId==-1;
        page = (page-1)*limit;
        List<PostingLike> cache = postingLikeMapper.findPostingLikeByPage(page,limit,postingId,userId);
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
            map.put("count",postingLikeMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer save(PostingLike postingLike) {
        return postingLikeMapper.save(postingLike);
    }

    public Map saveCode(PostingLike postingLike) {
        Integer cache = postingLikeMapper.save(postingLike);
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
    public Integer updateById(PostingLike postingLike) {
        return postingLikeMapper.updateById(postingLike);
    }

    public Map updateByIdCode(PostingLike postingLike) {
        Integer cache = postingLikeMapper.updateById(postingLike);
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
        return postingLikeMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = postingLikeMapper.DeleteById(id);
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
