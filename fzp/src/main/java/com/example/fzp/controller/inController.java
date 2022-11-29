package com.example.fzp.controller;

import com.example.fzp.entity.In;
import com.example.fzp.service.inService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/in")
public class inController {

    @Resource
    inService inService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return inService.findAllIn();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return inService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody In in) {
        return inService.saveCode(in);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody In in) {
        return inService.updateByIdCode(in);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return inService.DeleteByIdCode(id);
    }
}
