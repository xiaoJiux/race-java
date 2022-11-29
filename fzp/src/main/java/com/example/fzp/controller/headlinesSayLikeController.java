package com.example.fzp.controller;

import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.service.headlinesSayLikeService;
import com.example.fzp.service.headlinesSayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/headlinesSayLike")
public class headlinesSayLikeController {
    @Resource
    headlinesSayLikeService headlinesSayLikeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return headlinesSayLikeService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return headlinesSayLikeService.findByIdCode(id);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int headlinesSayId,@RequestParam int userId) {
        return headlinesSayLikeService.findHeadlinesSayLikeByPageCode(page,limit,headlinesSayId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody HeadlinesSayLike headlinesSayLike) {
        return headlinesSayLikeService.saveCode(headlinesSayLike);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody HeadlinesSayLike headlinesSayLike) {
        return headlinesSayLikeService.updateByIdCode(headlinesSayLike);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return headlinesSayLikeService.DeleteByIdCode(id);
    }
}
