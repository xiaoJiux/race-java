package com.example.fzp.controller;

import com.example.fzp.entity.Sign;
import com.example.fzp.entity.Study;
import com.example.fzp.service.signService;
import com.example.fzp.service.studyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/sign")
public class signController {
    @Resource
    signService signService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return signService.findAllSign();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return signService.findByIdCode(id);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int activityId,@RequestParam int signType, @RequestParam int userId) {
        return signService.findSignByPageCode(page,limit,activityId,signType,userId);
    }

    @PostMapping("findByUser")
    public Map findByUser(@RequestParam Long userId,Long activityId) {
        return signService.findByUserId(userId,activityId);
    }

    @PostMapping("save")
    public Map save(@RequestBody Sign sign) {
        return signService.saveCode(sign);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Sign sign) {
        return signService.updateByIdCode(sign);
    }

    @DeleteMapping("DeleteById")
    public Map DeleteById(Long id) {
        return signService.DeleteByIdCode(id);
    }
}
