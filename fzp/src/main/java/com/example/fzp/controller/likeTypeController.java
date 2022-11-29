package com.example.fzp.controller;

import com.example.fzp.entity.LikeType;
import com.example.fzp.entity.Opacity;
import com.example.fzp.service.likeTypeService;
import com.example.fzp.service.opacityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/likeType")
public class likeTypeController {

    @Resource
    likeTypeService likeTypeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return likeTypeService.findAllOpacity();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return likeTypeService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody LikeType likeType) {
        return likeTypeService.saveCode(likeType);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody LikeType likeType) {
        return likeTypeService.updateByIdCode(likeType);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return likeTypeService.DeleteByIdCode(id);
    }
}
