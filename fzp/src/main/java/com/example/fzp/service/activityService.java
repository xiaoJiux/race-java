package com.example.fzp.service;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.Study;
import com.example.fzp.entity.User;
import com.example.fzp.mapper.activityMapper;
import com.example.fzp.mapper.headlinesLikeMapper;
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
public class activityService implements activityMapper {
    @Resource
    activityMapper activityMapper;

    @Resource
    joinMapper joinMapper;

    @Resource
    userService userService;

    @Resource
    joinService joinService;

    @Override
    public List<Activity> findAll() {
        return activityMapper.findAll();
    }

    @Override
    public List<Activity> findAllIndex() {
        return null;
    }



    public Map findAllActivity() {
        List<Activity> activity = activityMapper.findAll();

        for (Activity i: activity) {
            i.setNowNum(joinService.findActivityCOUNT((long) i.getId()));
            i.setList(activityMapper.findUserForActivityList((long) i.getId()));
        }

        Map map = new HashMap();
        map.put("code",20000);
        map.put("message","查询成功");
        map.put("data",activity);
        return map;
    }

    public Map findAllActivityIndex() {
        List<Activity> activity = activityMapper.findAllIndex();

        for (Activity i: activity) {
            i.setNowNum(joinService.findActivityCOUNT((long) i.getId()));
            i.setList(activityMapper.findUserForActivityList((long) i.getId()));
        }

        Map map = new HashMap();
        map.put("code",20000);
        map.put("message","查询成功");
        map.put("data",activity);
        return map;
    }

    @Override
    public List<User> findUserForActivityList(Long activity) {
        return activityMapper.findUserForActivityList(activity);
    }

    @Override
    public List<Activity> findById(Long id) {
        return activityMapper.findById(id);
    }

    @Override
    public List<Activity> findByUserId(Long id) {
        return null;
    }

    public Map findByUserIdCode(Long id) {
        List<Activity> cache = activityMapper.findByUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");

        for (Activity i: cache) {
            i.setDUserSum(joinMapper.findActivityJoin((long) i.getId()).size());
        }

        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }


    public Map findByIdCode(Long id) {
        List<Activity> cache = activityMapper.findById(id);
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
    public List<Activity> findActivityByPage(int page, int limit, String name, String location, String unit, int userId, int state, int ins) {
        return null;
    }

    public Map findActivityByPageCode(int page, int limit, String name, String location, String unit, int userId, int state, int ins) {
        boolean bl = name.equals("-1")&&location.equals("-1")&&unit.equals("-1")&&state==-1&&ins==-1&&userId==-1;
        if (name.equals("-1"))
            name = null;
        else
            name = "%" + name + "%";
        if (location.equals("-1"))
            location = null;
        else
            location = "%" + location + "%";
        if (unit.equals("-1"))
            unit = null;
        else
            unit = "%" + unit + "%";
        page = (page-1)*limit;
        List<Activity> cache = activityMapper.findActivityByPage(page,limit,name,location,unit,userId,state,ins);
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
            map.put("count",activityMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public Integer save(Activity activity) {
        return activityMapper.save(activity);
    }

    public Map saveCode(Activity activity) {
        Integer cache = activityMapper.save(activity);
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
    public Integer updateById(Activity activity) {
        return activityMapper.updateById(activity);
    }

    public Map updateByIdCode(Activity activity) {
        Integer cache = activityMapper.updateById(activity);
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
        return activityMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = activityMapper.DeleteById(id);
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
