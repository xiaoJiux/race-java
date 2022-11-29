package com.example.fzp.controller;

import com.example.fzp.entity.StudySay;
import com.example.fzp.entity.StudySayLike;
import com.example.fzp.service.studySayLikeService;
import com.example.fzp.service.studySayLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/studySayLike")
public class studySayLikeController {
    @Resource
    studySayLikeService studySayLikeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studySayLikeService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studySayLikeService.findByIdCode(id);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int studySayId, @RequestParam int userId) {
        return studySayLikeService.findByPage(page,limit,studySayId,userId);
    }
    @PostMapping("save")
    public Map save(@RequestBody StudySayLike studySayLike) {
        return studySayLikeService.saveCode(studySayLike);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody StudySayLike studySayLike) {
        return studySayLikeService.updateByIdCode(studySayLike);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return studySayLikeService.DeleteByIdCode(id);
    }
}
