package com.example.fzp.controller;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.Headlines;
import com.example.fzp.service.activityService;
import com.example.fzp.service.headlinesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/activity")
public class activityController {
    @Resource
    activityService activityService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return activityService.findAllActivity();
    }

    @GetMapping("getAllForIndex")
    public Map getAllForIndex() {
        return activityService.findAllActivityIndex();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return activityService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return activityService.findByUserIdCode(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam String name, @RequestParam String location, @RequestParam String unit,@RequestParam int userId,@RequestParam int state,@RequestParam int in) {
        return activityService.findActivityByPageCode(page,limit,name,location,unit,userId,state,in);
    }


    @PostMapping("save")
    public Map save(@RequestBody Activity activity) {
        return activityService.saveCode(activity);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Activity activity) {
        return activityService.updateByIdCode(activity);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return activityService.DeleteByIdCode(id);
    }
}
