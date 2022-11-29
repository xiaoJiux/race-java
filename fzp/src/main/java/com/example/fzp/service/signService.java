package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.signMapper;
import com.example.fzp.mapper.studyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class signService implements signMapper {
    @Resource
    signMapper signMapper;

    @Override
    public List<Sign> findAll() {
        return signMapper.findAll();
    }

    public Map findAllSign() {
        List<Sign> cache = signMapper.findAll();
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
    public List<Sign> findById(Long id) {
        return signMapper.findById(id);
    }



    public Map findByIdCode(Long id) {
        List<Sign> cache = signMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","没有此活动id");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询活动id成功");
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    @Override
    public List<Sign> findSignByPage(int page, int limit, int activityId, int signType, int userId) {
        return null;
    }

    public Map findSignByPageCode(int page, int limit, int activityId, int signType, int userId) {
        boolean bl = activityId==-1&&signType==-1&&userId==-1;
        page = (page-1)*limit;
        List<Sign> cache = signMapper.findSignByPage(page,limit,activityId,signType,userId);
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
            map.put("count",signMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }


    @Override
    public List<Sign> findByUser(Long userId,Long activityId) {
        return signMapper.findByUser(userId,activityId);
    }

    public Map findByUserId(Long userId,Long activityId) {
        if (CollectionUtils.isEmpty(signMapper.findByUser(userId,activityId))){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","没有此用户签到信息");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        map.put("data",signMapper.findByUser(userId,activityId));
        return map;
    }

    @Override
    public Integer save(Sign sign) {
        return signMapper.save(sign);
    }

    public Map saveCode(Sign sign) {
        Integer cache = signMapper.save(sign);
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
    public Integer updateById(Sign sign) {
        return signMapper.updateById(sign);
    }

    public Map updateByIdCode(Sign sign) {
        Integer cache = signMapper.updateById(sign);
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
        return signMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = signMapper.DeleteById(id);
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
