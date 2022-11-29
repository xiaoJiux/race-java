package com.example.fzp.controller;

import com.example.fzp.entity.In;
import com.example.fzp.entity.State;
import com.example.fzp.service.inService;
import com.example.fzp.service.stateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/state")
public class stateController {

    @Resource
    stateService stateService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return stateService.findAll();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return stateService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody State state) {
        return stateService.saveCode(state);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody State state) {
        return stateService.updateByIdCode(state);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return stateService.DeleteByIdCode(id);
    }
}
