package com.example.fzp.controller;

import com.example.fzp.service.likeTypeService;
import com.example.fzp.service.machineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/machine")
public class machineController {
    @Resource
    machineService machineService;

    @PostMapping("findKeyAll")
    public Map findKeyAll(@RequestParam String id) {
        return machineService.findKeyAll(id);
    }

    @PostMapping("findAll")
    public Map findAll() {
        return machineService.findAll();
    }

}
