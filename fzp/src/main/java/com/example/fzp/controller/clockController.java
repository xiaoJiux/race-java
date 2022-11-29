package com.example.fzp.controller;

import com.example.fzp.entity.Clock;
import com.example.fzp.entity.Opacity;
import com.example.fzp.service.clockService;
import com.example.fzp.service.opacityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/clock")
public class clockController {
    @Resource
    clockService clockService;

    @GetMapping("getAll")
    public Map getAllUser() {
        return clockService.findAll();
    }

    @PostMapping("findByUserId")
    public Map findById(@RequestParam Long userId) {
        return clockService.findByIdCode(userId);
    }

    @PostMapping("findByClockDay")
    public Map findByClockDay(@RequestParam Long userId) {
        return clockService.findByClockDay(userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody Clock clock) throws ParseException {
        return clockService.save(clock);
    }

}
