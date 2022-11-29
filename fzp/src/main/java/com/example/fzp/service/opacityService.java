package com.example.fzp.service;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.entity.Join;
import com.example.fzp.entity.Opacity;
import com.example.fzp.mapper.joinMapper;
import com.example.fzp.mapper.opacityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class opacityService implements opacityMapper {
    @Resource
    opacityMapper opacityMapper;

    @Override
    public List<Opacity> findAll() {
        return opacityMapper.findAll();
    }

    public Map findAllOpacity() {
        List<Opacity> cache = opacityMapper.findAll();
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
    public List<Opacity> findById(Long id) {
        return opacityMapper.findById(id);
    }

    public Map findByIdCode(Long id) {
        List<Opacity> cache = opacityMapper.findById(id);
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
    public Integer save(Opacity opacity) {
        return opacityMapper.save(opacity);
    }

    public Map saveCode(Opacity opacity) {
        Integer cache = opacityMapper.save(opacity);
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
    public Integer updateById(Opacity opacity) {
        return opacityMapper.updateById(opacity);
    }

    public Map updateByIdCode(Opacity opacity) {
        Integer cache = opacityMapper.updateById(opacity);
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
        return opacityMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = opacityMapper.DeleteById(id);
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
