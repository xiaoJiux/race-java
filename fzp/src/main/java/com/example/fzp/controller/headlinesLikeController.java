package com.example.fzp.controller;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.HeadlinesSayLike;
import com.example.fzp.service.headlinesLikeService;
import com.example.fzp.service.headlinesSayLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/headlinesLike")
public class headlinesLikeController {
    @Resource
    headlinesLikeService headlinesLikeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return headlinesLikeService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return headlinesLikeService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return headlinesLikeService.findByLikeTypeIdCode(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int headlinesId,@RequestParam int userId,@RequestParam int likeType) {
        return headlinesLikeService.findHeadlinesLikeByPageCode(page,limit,headlinesId,userId,likeType);
    }

    @PostMapping("save")
    public Map save(@RequestBody HeadlinesLike headlinesLike) {
        return headlinesLikeService.saveCode(headlinesLike);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody HeadlinesLike headlinesLike) {
        return headlinesLikeService.updateByIdCode(headlinesLike);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return headlinesLikeService.DeleteByIdCode(id);
    }
}
