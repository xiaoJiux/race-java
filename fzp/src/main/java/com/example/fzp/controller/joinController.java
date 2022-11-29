package com.example.fzp.controller;

import com.example.fzp.entity.Activity;
import com.example.fzp.entity.Join;
import com.example.fzp.service.activityService;
import com.example.fzp.service.joinService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/join")
public class joinController {
    @Resource
    joinService joinService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return joinService.findAllJoin();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return joinService.findByIdCode(id);
    }

    @PostMapping("findByUser")
    public Map findByUser(@RequestParam Long userId) {
        return joinService.findByUser(userId);
    }

    @PostMapping("findActivityCOUNT")
    public Map findActivityCOUNT(Long activityId) {
        return joinService.findActivityCount(activityId);
    }

    @PostMapping("findActivityJoin")
    public Map findActivityJoin(Long activityId) {
        return joinService.findActivityJoinCode(activityId);
    }

    @PostMapping("findActivityJoinPass")
    public Map findActivityJoinPass(Long activityId) {
        return joinService.findActivityJoinPassCode(activityId);
    }

   @PostMapping("findActivityJoinFailed")
    public Map findActivityJoinFailed(Long activityId) {
        return joinService.findActivityJoinFailedCode(activityId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int activityId, @RequestParam int userId) {
        return joinService.findByPageCode(page,limit,activityId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody Join join) {
        return joinService.saveJoin(join);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Join join) {
        return joinService.updateByIdCode(join);
    }

    @PostMapping("updateExamineById")
    public Map updateExamineById(@RequestParam Long joinId) {
        return joinService.updateExamineByIdCode(joinId);
    }

    @PostMapping("updateExamine3ById")
    public Map updateExamine3ById(@RequestParam Long joinId) {
        return joinService.updateExamine3ByIdCode(joinId);
    }

    @DeleteMapping("DeleteById")
    public Map DeleteById(Long id) {
        return joinService.DeleteByIdCode(id);
    }
}
