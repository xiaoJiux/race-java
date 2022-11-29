package com.example.fzp.service;

import com.example.fzp.entity.*;
import com.example.fzp.mapper.clockMapper;
import com.example.fzp.mapper.pointsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class pointsService implements pointsMapper {
    @Resource
    pointsMapper pointsMapper;

    @Resource
    clockMapper clockMapper;


    @Override
    public List<Points> findAll() {
        return pointsMapper.findAll();
    }

    @Override
    public List<Points> findTypeCOUNT(Long userId) {
        return null;
    }

    public Map findTypeCOUNTCode(Long userId) {
        List<Points> cache = pointsMapper.findById(userId);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        for (Points i: cache) {
            List<Points> j = pointsMapper.findTypeCOUNT((long) i.getUser());
            for (Points k: j) {
                System.out.println("k.type= "+k.getType());
                if (k.getType()!=0)
                    switch(k.getType()){
                        case 1 :
                            i.setType1(k.getCOUNTID());
                            break; //可选
                        case 2 :
                            i.setType2(k.getCOUNTID());
                            break; //可选
                        case 3 :
                            i.setType3(k.getCOUNTID());
                            break; //可选
                        case 4 :
                            i.setType4(k.getCOUNTID());
                            break; //可选
                        case 5 :
                            i.setType5(k.getCOUNTID());
                            break; //可选
                        case 6 :
                            i.setType6(k.getCOUNTID());
                            break; //可选

                    }
            }

        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;
    }

    @Override
    public List<Points> findAllSumPointsLimit3() {
        return null;
    }

    @Override
    public List<Points> findAllSumPointsInsLimit3() {
        return null;
    }

    public Map findAllSumPointsLimit3Code() {
        List<Points> cache = pointsMapper.findAllSumPointsLimit3();
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

    public Map findAllSumPointsInsLimit3Code() {
        List<Points> cache = pointsMapper.findAllSumPointsInsLimit3();
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

    public Map findAllPoints() {
        List<Points> cache = pointsMapper.findAll();
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

    public Map findByUserIdCode(Long userId) {
        List<Points> cache = pointsMapper.findByUserId(userId);
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
    public List<Points> findById(Long id) {
        return pointsMapper.findById(id);
    }

    @Override
    public List<Points> findByUserId(Long id) {
        return null;
    }


    @Override
    public List<Points> findPointsByPage(int page, int limit, String name, String info) {
        return null;
    }

    public Map findPointsByPageCode(int page, int limit, String name, String info) {
        boolean bl = name.equals("-1")&&info.equals("-1");
        if (info.equals("-1"))
            info = null;
        else
            info = "%" + info + "%";
        if (name.equals("-1")) name = null;
        page = (page-1)*limit;
        List<Points> cache = pointsMapper.findPointsByPage(page, limit, name, info);
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
            map.put("count",pointsMapper.findAll().size());
        else
            map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }


    public Map findByIdCode(Long id) {
        List<Points> cache = pointsMapper.findById(id);
        if (CollectionUtils.isEmpty(cache)){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","查询id失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","查询id成功");
        System.out.println("这是cache=  "+cache);
        for (Points i: cache) {
            i.setClockDay(clockMapper.findByClockDayForUser(id));
            List<Points> j = pointsMapper.findTypeCOUNT(id);
            if (j.get(0)==null)
                continue;
            for (Points k: j) {
                if (k.getType()!=0)
                    switch(k.getType()){
                        case 1 :
                            i.setType1(k.getCOUNTID());
                            break; //可选
                        case 2 :
                            i.setType2(k.getCOUNTID());
                            break; //可选
                        case 3 :
                            i.setType3(k.getCOUNTID());
                            break; //可选
                        case 4 :
                            i.setType4(k.getCOUNTID());
                            break; //可选
                        case 5 :
                            i.setType5(k.getCOUNTID());
                            break; //可选
                        case 6 :
                            i.setType6(k.getCOUNTID());
                            break; //可选

                    }
            }

        }
        map.put("count",cache.size());
        map.put("data",cache);
        return map;

    }

    @Override
    public Integer save(Points points) {
        return pointsMapper.save(points);
    }

    public Map saveCode(Points points) {
        Integer cache = pointsMapper.save(points);
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
    public Integer updateById(Points points) {
        return pointsMapper.updateById(points);
    }

    @Override
    public Integer reducePoints(Long id, Long points, String info) {
        return null;
    }


    public Map reducePointsCode(Long id, Long points, String info) {
        points = -points;
        Integer cache = pointsMapper.reducePoints(id,points, info);
        if (cache==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","积分兑换失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","积分兑换成功");
        map.put("count",cache);
        return map;
    }

    public Map updateByIdCode(Points points) {
        Integer cache = pointsMapper.updateById(points);
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
        return pointsMapper.DeleteById(id);
    }

    public Map DeleteByIdCode(Long id) {
        Integer cache = pointsMapper.DeleteById(id);
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
