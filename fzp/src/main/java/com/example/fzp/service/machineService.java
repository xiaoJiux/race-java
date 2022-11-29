package com.example.fzp.service;

import com.example.fzp.entity.Machine;
import com.example.fzp.mapper.machineMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class machineService {

    @Resource
    machineMapper machineMapper;


    public Map findKeyAll(String key) {
        boolean flag = true;
        try {
            Integer.parseInt(key);

        } catch (NumberFormatException e) {
//            System.out.println("异常：" + key + "不是数字/整数...");
            flag = false;
        }
        if (key.length()== 1 && flag){
            List<Machine> cache = machineMapper.findKeyAll(key);
            if (CollectionUtils.isEmpty(cache)) {
                Map map = new HashMap<>();
                map.put("code", 1);
                map.put("message", "没查询到关键字");
                return map;
            }
            Map map = new HashMap<>();
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("count", cache.size());
            map.put("data", cache);
            return map;
        }else{
            System.out.println("进入else");
            List<Machine> cache = machineMapper.findMachine(key);
            if (CollectionUtils.isEmpty(cache)) {
                Map map = new HashMap<>();
                map.put("code", 1);
                map.put("message", "没查询到关键字");
                return map;
            }
            Map map = new HashMap<>();
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("count", cache.size());
            map.put("data", cache);
            return map;
        }

    }

    public Map findAll() {

        List<Machine> cache = machineMapper.findAll();
        if (CollectionUtils.isEmpty(cache)) {
            Map map = new HashMap<>();
            map.put("code", 1);
            map.put("message", "查询为空");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "查询成功");
        map.put("count", cache.size());
        map.put("data", cache);
        return map;
    }

}
