package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.studyTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class studyTypeService implements studyTypeMapper {
    @Resource
    studyTypeMapper studyTypeMapper;

    @Override
    public List<StudyType> findAll() {
        return studyTypeMapper.findAll();
    }

    public Map findAllStudyType() {
        List<StudyType> cache = studyTypeMapper.findAll();
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
    public List<StudyType> findById(Long id) {
        return studyTypeMapper.findById(id);
    }

    public Map findByIdCode(Long id) {
        List<StudyType> cache = studyTypeMapper.findById(id);
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
    public Integer save(StudyType studyType) {
        return studyTypeMapper.save(studyType);
    }

    public Map saveCode(StudyType studyType) {
        Integer cache = studyTypeMapper.save(studyType);
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
    public Integer updateById(StudyType studyType) {
        return studyTypeMapper.updateById(studyType);
    }

    public Map updateByIdCode(StudyType studyType) {
        Integer cache = studyTypeMapper.updateById(studyType);
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
        return studyTypeMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = studyTypeMapper.DeleteById(id);
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
