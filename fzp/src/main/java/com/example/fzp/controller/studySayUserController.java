package com.example.fzp.controller;

import com.example.fzp.entity.StudySayLike;
import com.example.fzp.entity.StudySayUser;
import com.example.fzp.service.studySayLikeService;
import com.example.fzp.service.studySayUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/studySayUser")
public class studySayUserController {

    @Resource
    studySayUserService studySayUserService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studySayUserService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studySayUserService.findByIdCode(id);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit,@RequestParam int byUserId, @RequestParam int userId) {
        return studySayUserService.findSignByPage(page,limit,byUserId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody StudySayUser studySayUser) {
        return studySayUserService.saveCode(studySayUser);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody StudySayUser studySayUser) {
        return studySayUserService.updateByIdCode(studySayUser);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return studySayUserService.DeleteByIdCode(id);
    }
}
