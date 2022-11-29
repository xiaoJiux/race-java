package com.example.fzp.controller;

import com.example.fzp.entity.Institute;
import com.example.fzp.entity.Join;
import com.example.fzp.service.instituteService;
import com.example.fzp.service.joinService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/institute")
public class instituteController {
    @Resource
    instituteService instituteService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return instituteService.findAllInstitute();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return instituteService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody Institute institute) {
        return instituteService.saveCode(institute);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Institute institute) {
        return instituteService.updateByIdCode(institute);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return instituteService.DeleteByIdCode(id);
    }
}
