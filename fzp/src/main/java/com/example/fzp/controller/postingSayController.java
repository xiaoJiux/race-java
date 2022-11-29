package com.example.fzp.controller;

import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.entity.PostingSay;
import com.example.fzp.service.headlinesSayService;
import com.example.fzp.service.postingSayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/postingSay")
public class postingSayController {
    @Resource
    postingSayService postingSayService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return postingSayService.findAllPostingSay();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return postingSayService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return postingSayService.findByUserIdCode(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int postingId,@RequestParam int userId) {
        return postingSayService.findPostingSayByPageCode(page,limit,postingId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody PostingSay postingSay) {
        return postingSayService.saveCode(postingSay);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody PostingSay postingSay) {
        return postingSayService.updateByIdCode(postingSay);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return postingSayService.DeleteByIdCode(id);
    }
}
