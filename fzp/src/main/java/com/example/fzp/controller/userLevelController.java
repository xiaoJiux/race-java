package com.example.fzp.controller;

import com.example.fzp.entity.Sex;
import com.example.fzp.entity.userLevel;
import com.example.fzp.service.sexService;
import com.example.fzp.service.userLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/userLevel")
public class userLevelController {

    @Resource
    userLevelService userLevelService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return userLevelService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return userLevelService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody userLevel userLevel) {
        return userLevelService.saveCode(userLevel);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody userLevel userLevel) {
        return userLevelService.updateByIdCode(userLevel);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return userLevelService.DeleteByIdCode(id);
    }
}
