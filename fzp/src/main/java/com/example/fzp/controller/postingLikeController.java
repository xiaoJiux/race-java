package com.example.fzp.controller;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.PostingLike;
import com.example.fzp.service.headlinesLikeService;
import com.example.fzp.service.postingLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/postingLike")
public class postingLikeController {
    @Resource
    postingLikeService postingLikeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return postingLikeService.findAllPostingLike();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return postingLikeService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return postingLikeService.findByLikeTypeIdCode(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int postingId, @RequestParam int userId) {
        return postingLikeService.findPostingLikeByPageCode(page,limit,postingId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody PostingLike postingLike) {
        return postingLikeService.saveCode(postingLike);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody PostingLike postingLike) {
        return postingLikeService.updateByIdCode(postingLike);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return postingLikeService.DeleteByIdCode(id);
    }
}
