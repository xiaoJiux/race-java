package com.example.fzp.service;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.entity.Institute;
import com.example.fzp.entity.Join;
import com.example.fzp.mapper.instituteMapper;
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
public class instituteService implements instituteMapper {
    @Resource
    instituteMapper instituteMapper;

    @Override
    public List<Institute> findAll() {
        return instituteMapper.findAll();
    }

    public Map findAllInstitute() {
        List<Institute> cache = instituteMapper.findAll();
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
    public List<Institute> findById(Long id) {
        return instituteMapper.findById(id);
    }

    public Map findByIdCode(Long id) {
        List<Institute> cache = instituteMapper.findById(id);
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
    public Integer save(Institute institute) {
        return instituteMapper.save(institute);
    }

    public Map saveCode(Institute institute) {
        Integer cache = instituteMapper.save(institute);
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
    public Integer updateById(Institute institute) {
        return instituteMapper.updateById(institute);
    }

    public Map updateByIdCode(Institute institute) {
        Integer cache = instituteMapper.updateById(institute);
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
        return instituteMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = instituteMapper.DeleteById(id);
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
