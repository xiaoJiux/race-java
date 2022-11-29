package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.studyLikeMapper;
import com.example.fzp.mapper.studyMapper;
import com.example.fzp.mapper.studySayMapper;
import com.example.fzp.mapper.studySayUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@Transactional
@Service
public class studyService implements studyMapper{
    @Resource
    studyMapper studyMapper;

    @Resource
    studyLikeMapper studyLikeMapper;

    @Resource
    studySayMapper studySayMapper;

    @Resource
    studySayUserMapper studySayUserMapper;

    @Override
    public List<Study> findAll() {
        return studyMapper.findAll();
    }

    @Override
    public List<Study> findAllOR() {
        return null;
    }

    @Override
    public List<Study> findAllVision() {
        return null;
    }

    @Override
    public List<Study> findAllTiktok() {
        return null;
    }

    @Override
    public List<Study> findByVisionId(Long id) {
        return null;
    }

    @Override
    public List<Study> findByTiktokId(Long id) {
        return null;
    }

    public Map findByVisionIdCode(Long id) {
        List<Study> cache = studyMapper.findByVisionId(id);
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

    public Map findByTiktokIdCode(Long id) {
        List<Study> cache = studyMapper.findByTiktokId(id);
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

    public Map findAllVisionCode() {
        List<Study> cache = studyMapper.findAllVision();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findAllTiktokCode() {
        List<Study> cache = studyMapper.findAllTiktok();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map findAllStudy() {
        List<Study> cache = studyMapper.findAll();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }
    public Map findAllStudyOR() {
        List<Study> cache = studyMapper.findAllOR();
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查无此人");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<Study> findById(Long id) {
        return studyMapper.findById(id);
    }

    @Override
    public List<Study> findByUserId(Long id) {
        return null;
    }

    @Override
    public List<Study> findByVisionUserId(Long id) {
        return null;
    }

    @Override
    public List<Study> findByTiktokUserId(Long id) {
        return null;
    }


    public Map findByIdCode(Long id) {
        List<Study> cache = studyMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByUserIdCode(Long id) {
        List<Study> cache = studyMapper.findByUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByVisionUserIdCode(Long id) {
        List<Study> cache = studyMapper.findByVisionUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    public Map findByTiktokUserIdCode(Long id) {
        List<Study> cache = studyMapper.findByTiktokUserId(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (Study i: cache) {
            i.setLikeCOUNT(studyLikeMapper.findByLikeType1COUNT((long) i.getId()));
            i.setSaveCOUNT(studyLikeMapper.findByLikeType2COUNT((long) i.getId()));
        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }



    @Override
    public List<Study> findPostingByPage(int page, int limit, String name, String location, int studyType, int userId) {
        return null;
    }

    public Map findPostingByPageCode(int page, int limit, String name, String location, int studyType, int userId) {
        boolean bl = name.equals("-1")&&location.equals("-1")&&studyType==-1&&userId==-1;
        if (name.equals("-1"))
            name = null;
        else
            name = "%" + name + "%";

        if (location.equals("-1"))
            location = null;
        else
            location = "%" + location + "%";
        page = (page-1)*limit;
        List<Study> cache = studyMapper.findPostingByPage(page,limit,name,location,studyType,userId);
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
            map.put("count",studyMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    public Map studySayData(Long id){
        Map map = new HashMap();
        List SayList = new ArrayList();
        List SayUserList = new ArrayList();
            List<StudySay> Say = studySayMapper.findByStudyId(id);
            SayList.add(Say);
            for (StudySay j: Say) {
                List<StudySayUser> SayUser = studySayUserMapper.findByStudySayId((long) j.getId());
                if (!CollectionUtils.isEmpty(SayUser)) {
                    SayUserList.add(SayUser);
                }
                j.setChildrenSay(SayUserList);
            }
            SayUserList = new ArrayList();

        map.put("code",0);
        map.put("message","查询成功");
        map.put("count",SayList.size());
        map.put("data",SayList);
        return map;
    }

    @Override
    public Integer save(Study study) {
        return studyMapper.save(study);
    }

    public Map saveCode(Study study) {
        Integer cache = studyMapper.save(study);
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

    public Map saveEyes(Study study) {
        study.setType(5);
        Integer cache = studyMapper.save(study);
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

    public Map saveTiktok(Study study) {
        study.setType(9);
        Integer cache = studyMapper.save(study);
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
    public Integer updateById(Study study) {
        return studyMapper.updateById(study);
    }

    public Map updateByIdCode(Study study) {
        Integer cache = studyMapper.updateById(study);
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
        return studyMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = studyMapper.DeleteById(id);
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
