package com.example.fzp.controller;

import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.entity.PostingSayLike;
import com.example.fzp.service.headlinesSayLikeService;
import com.example.fzp.service.postingSayLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/postingSayLike")
public class postingSayLikeController {
    @Resource
    postingSayLikeService postingSayLikeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return postingSayLikeService.findAllPostingSayLike();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return postingSayLikeService.findByIdCode(id);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int postingSayId,@RequestParam int userId) {
        return postingSayLikeService.findPostingSayLikeByPageCode(page,limit,postingSayId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody PostingSayLike postingSayLike) {
        return postingSayLikeService.saveCode(postingSayLike);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody PostingSayLike postingSayLike) {
        return postingSayLikeService.updateByIdCode(postingSayLike);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return postingSayLikeService.DeleteByIdCode(id);
    }
}
