package com.example.fzp.service;

import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.StudyLike;
import com.example.fzp.entity.StudySay;
import com.example.fzp.mapper.studyLikeMapper;
import com.example.fzp.mapper.studySayLikeMapper;
import com.example.fzp.mapper.studySayMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class studySayService {
    @Resource
    studySayMapper studySayMapper;

    @Resource
    studySayLikeMapper studySayLikeMapper;

    public Map findAllCode() {
        List<StudySay> cache = studySayMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findVisionAll() {
        List<StudySay> cache = studySayMapper.findVisionAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findTiktokAll() {
        List<StudySay> cache = studySayMapper.findTiktokAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByVisionUserId(Long id) {
        List<StudySay> cache = studySayMapper.findByVisionUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByTiktokUserId(Long id) {
        List<StudySay> cache = studySayMapper.findByTiktokUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByVisionId(Long id) {
        List<StudySay> cache = studySayMapper.findByVisionId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByTiktokId(Long id) {
        List<StudySay> cache = studySayMapper.findByTiktokId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByVisionSayVisionId(Long id) {
        List<StudySay> cache = studySayMapper.findByVisionSayVisionId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findByTiktokSayTiktokId(Long id) {
        List<StudySay> cache = studySayMapper.findByTiktokSayTiktokId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }


    public Map findByIdCode(Long id) {
        List<StudySay> cache = studySayMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByUserIdCode(Long id) {
        List<StudySay> cache = studySayMapper.findByUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (StudySay i: cache) {
            i.setLikeCOUNT(studySayLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByPageCode(int page, int limit, int studyId, int userId) {
        boolean bl = studyId==-1&&userId==-1;
        page = (page-1)*limit;
        List<StudySay> cache = studySayMapper.findByPage(page,limit, studyId, userId);
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
            map.put("count",studySayMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map saveCode(StudySay studySay) {
        Integer cache = studySayMapper.save(studySay);
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


    public Map updateByIdCode(StudySay studySay) {
        Integer cache = studySayMapper.updateById(studySay);
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
        Integer cache = studySayMapper.DeleteById(id);
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
