package com.example.fzp.controller;

import com.example.fzp.entity.Headlines;
import com.example.fzp.entity.Study;
import com.example.fzp.service.headlinesService;
import com.example.fzp.service.studyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/headlines")
public class headlinesController {
    @Resource
    headlinesService headlinesService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return headlinesService.findAllCode();
    }

    @GetMapping("getAllUserIndex")
    public Map getAllUserIndex() {
        return headlinesService.findAllIndexCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return headlinesService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return headlinesService.findByUserIdCode(userId);
    }



    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam String name,@RequestParam int userId) {
        return headlinesService.findHeadlinesByPageCode(page,limit,name,userId);
    }


    @PostMapping("save")
    public Map save(@RequestBody Headlines headlines) {
        return headlinesService.saveCode(headlines);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Headlines headlines) {
        return headlinesService.updateByIdCode(headlines);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return headlinesService.DeleteByIdCode(id);
    }

}
