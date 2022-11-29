package com.example.fzp.controller;

import com.example.fzp.entity.Headlines;
import com.example.fzp.entity.Posting;
import com.example.fzp.service.headlinesService;
import com.example.fzp.service.postingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/posting")
public class postingController {
    @Resource
    postingService postingService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return postingService.findAllPosting();
    }

    @GetMapping("getAllForIndex")
    public Map getAllIndex() {
        return postingService.findAllIndexCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return postingService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return postingService.findByUserIdCode(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam String name, @RequestParam int opacityId,@RequestParam int levelId,@RequestParam int userId) {
        return postingService.findPostingByPageCode(page,limit,name,opacityId,levelId,userId);
    }

    @PostMapping("findBySayData")
    public Map findBySayData(Long postingId) {
        return postingService.postingSayData(postingId);
    }


    @PostMapping("save")
    public Map save(@RequestBody Posting posting) {
        return postingService.saveCode(posting);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Posting posting) {
        return postingService.updateByIdCode(posting);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return postingService.DeleteByIdCode(id);
    }

    @GetMapping("getAllUserMessage")
    public Map getAllUserMessage() {
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("message","成功获取信息");
        map.put("data",postingService.findAll());
        return map;
    }




}
