package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class postingService implements postingMapper {
    @Resource
    postingMapper postingMapper;

    @Resource
    postingLikeMapper postingLikeMapper;

    @Resource
    postingSayMapper postingSayMapper;

    @Resource
    postingSayLikeMapper postingSayLikeMapper;

    @Override
    public List<Posting> findAll() {
        return postingMapper.findAll();
    }

    @Override
    public List<Posting> findAllIndex() {
        return null;
    }

    public Map findAllIndexCode() {
        List<Posting> cache = postingMapper.findAllIndex();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");

        for (Posting i: cache) {
            i.setLikeCOUNT(postingLikeMapper.findByLikeCOUNT((long) i.getId()));
            i.setSayCOUNT(postingSayMapper.findBySayCOUNT((long) i.getId()));
        }

        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findAllPosting() {
        List<Posting> cache = postingMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Posting i: cache) {
            i.setLikeCOUNT(postingLikeMapper.findByLikeCOUNT((long) i.getId()));
            i.setSayCOUNT(postingSayMapper.findBySayCOUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<Posting> findById(Long id) {
        return postingMapper.findById(id);
    }

    @Override
    public List<Posting> findByUserId(Long id) {
        return null;
    }

    public Map findByUserIdCode(Long id) {
        List<Posting> cache = postingMapper.findByUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Posting i: cache) {
            i.setLikeCOUNT(postingLikeMapper.findByLikeCOUNT((long) i.getId()));
            i.setSayCOUNT(postingSayMapper.findBySayCOUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<Posting> findPostingByPage(int page, int limit, String name, int opacityId, int levelId, int userId) {
        return null;
    }

    public Map findPostingByPageCode(int page, int limit, String name, int opacityId, int levelId, int userId) {
        boolean bl = name.equals("-1")&&opacityId==-1&&levelId==-1&&userId==-1;
        if (name.equals("-1"))
            name = null;
        else
            name = "%" + name + "%";
        page = (page-1)*limit;
        List<Posting> cache = postingMapper.findPostingByPage(page,limit,name,opacityId,levelId,userId);
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
            map.put("count",postingMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByIdCode(Long id) {
        List<Posting> cache = postingMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (Posting i: cache) {
            i.setLikeCOUNT(postingLikeMapper.findByLikeCOUNT((long) i.getId()));
            i.setSayCOUNT(postingSayMapper.findBySayCOUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }



    public Map postingSayData(Long id){
        List<PostingSay> cache = postingSayMapper.findByPostingId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id为空");
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
    public Integer save(Posting posting) {
        return postingMapper.save(posting);
    }

    public Map saveCode(Posting posting) {
        Integer cache = postingMapper.save(posting);
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
    public Integer updateById(Posting posting) {
        return postingMapper.updateById(posting);
    }

    public Map updateByIdCode(Posting posting) {
        Integer cache = postingMapper.updateById(posting);
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
        return postingMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = postingMapper.DeleteById(id);
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
