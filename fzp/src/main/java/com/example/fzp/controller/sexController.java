package com.example.fzp.controller;

import com.example.fzp.entity.Opacity;
import com.example.fzp.entity.Sex;
import com.example.fzp.service.opacityService;
import com.example.fzp.service.sexService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/sex")
public class sexController {
    @Resource
    sexService sexService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return sexService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return sexService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody Sex sex) {
        return sexService.saveCode(sex);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Sex sex) {
        return sexService.updateByIdCode(sex);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return sexService.DeleteByIdCode(id);
    }
}
