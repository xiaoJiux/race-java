package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.joinMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class joinService implements joinMapper {
    @Resource
    joinMapper joinMapper;

    @Override
    public List<Join> findAll() {
        return joinMapper.findAll();
    }

    public Map findAllJoin() {
        List<Join> cache = joinMapper.findAll();
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
    public List<Join> findById(Long id) {
        return joinMapper.findById(id);
    }

    public Map findByIdCode(Long id) {
        List<Join> cache = joinMapper.findById(id);
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
    public List<Join> findByUserId(Long userId) {
        return findById(userId);
    }

    public Map findByUser(Long userId) {
        if (CollectionUtils.isEmpty(joinMapper.findByUserId(userId))){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","没有此用户活动信息");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        map.put("count",joinMapper.findByUserId(userId).size());
        map.put("data",joinMapper.findByUserId(userId));
        return map;
    }

    @Override
    public Integer findActivityCOUNT(Long activityId) {
        return joinMapper.findActivityCOUNT(activityId);
    }

    @Override
    public List<Join> findActivityJoin(Long activityId) {
        return null;
    }

    @Override
    public List<Join> findActivityJoinPass(Long activityId) {
        return null;
    }

    public Map findActivityJoinPassCode(Long activityId) {
        List<Join> cache = joinMapper.findActivityJoinPass(activityId);
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

    @Override
    public List<Join> findActivityJoinFailed(Long activityId) {
        return null;
    }

    public Map findActivityJoinFailedCode(Long activityId) {
        List<Join> cache = joinMapper.findActivityJoinFailed(activityId);
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

    public Map findActivityJoinCode(Long activityId) {
        List<Join> cache = joinMapper.findActivityJoin(activityId);
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

    @Override
    public List<Join> findByPage(int page, int limit, int activityId, int userId) {
        return null;
    }

    public Map findByPageCode(int page, int limit, int activityId, int userId) {
        boolean bl = activityId==-1&&userId==-1;
        page = (page-1)*limit;
        List<Join> cache = joinMapper.findByPage(page,limit,activityId,userId);
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
            map.put("count",joinMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findActivityCount(Long activityId) {
        Integer cache = joinMapper.findActivityCOUNT(activityId);
        System.out.println(cache);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        map.put("count",cache);
        return map;
    }

    @Override
    public Integer save(Join join) {
        return joinMapper.save(join);
    }


    public Map saveJoin(Join join) {
        Integer cache = joinMapper.save(join);
        System.out.println(cache);
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
    public Integer updateById(Join join) {
        return joinMapper.updateById(join);
    }

    @Override
    public Integer updateExamineById(Long examine) {
        return null;
    }

    @Override
    public Integer updateExamine3ById(Long id) {
        return null;
    }

    public Map updateExamineByIdCode(Long examine) {
        Integer cache = joinMapper.updateExamineById(examine);
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

    public Map updateExamine3ByIdCode(Long examine) {
        Integer cache = joinMapper.updateExamine3ById(examine);
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

    public Map updateByIdCode(Join join) {
        Integer cache = joinMapper.updateById(join);
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
        return joinMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = joinMapper.DeleteById(id);
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
