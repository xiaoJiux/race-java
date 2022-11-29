package com.example.fzp.controller;

import com.example.fzp.entity.Headlines;
import com.example.fzp.entity.HeadlinesSay;
import com.example.fzp.service.headlinesSayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/headlinesSay")
public class headlinesSayController {
    @Resource
    headlinesSayService headlinesSayService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return headlinesSayService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return headlinesSayService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return headlinesSayService.findByUserIdCode(userId);
    }

    @PostMapping("findByHeadlinesId")
    public Map findByHeadlinesIdId(@RequestParam Long headlinesId) {
        return headlinesSayService.findByHeadlinesIdCode(headlinesId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int headlines,@RequestParam int userId) {
        return headlinesSayService.findHeadlinesSayByPageCode(page,limit,headlines,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody HeadlinesSay headlinesSay) {
        return headlinesSayService.saveCode(headlinesSay);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody HeadlinesSay headlinesSay) {
        return headlinesSayService.updateByIdCode(headlinesSay);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return headlinesSayService.DeleteByIdCode(id);
    }

}
