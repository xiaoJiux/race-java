package com.example.fzp.controller;

import com.example.fzp.entity.Opacity;
import com.example.fzp.entity.Points;
import com.example.fzp.service.opacityService;
import com.example.fzp.service.pointsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/opacity")
public class opacityController {
    @Resource
    opacityService opacityService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return opacityService.findAllOpacity();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return opacityService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody Opacity opacity) {
        return opacityService.saveCode(opacity);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Opacity opacity) {
        return opacityService.updateByIdCode(opacity);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return opacityService.DeleteByIdCode(id);
    }
}
