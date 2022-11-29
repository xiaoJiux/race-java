package com.example.fzp.service;

import com.example.fzp.entity.Clock;
import com.example.fzp.entity.State;
import com.example.fzp.mapper.clockMapper;
import com.example.fzp.mapper.stateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class clockService {

    @Resource
    clockMapper clockMapper;

    public Map findAll() {
        List<Clock> cache = clockMapper.findAll();
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

    public Map findByIdCode(Long id) {
        List<Clock> cache = clockMapper.findById(id);
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

    public Map findByClockDay(Long id) {
        Integer cache = clockMapper.findByClockDayForUser(id);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","暂未签到数据");
            map.put("data",0);
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        map.put("data",cache);
        return map;

    }

    public Map save(Clock clock) throws ParseException {
        if (!CollectionUtils.isEmpty(clockMapper.findByDateAndUserId(clock.getDate(), (long) clock.getUser()))){
            Map map = new HashMap<>();
            map.put("code",2);
            map.put("message","今天已经签到过");
            return map;
        }
        Integer cache = clockMapper.save(clock);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","新增失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","新增签到成功");
        map.put("count",cache);
        return map;
    }


    public Map updateByIdCode(Clock clock) {
        Integer cache = clockMapper.updateById(clock);
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

    public Map DeleteByIdCode(Long id) {
        Integer cache = clockMapper.DeleteById(id);
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
