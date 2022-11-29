package com.example.fzp.controller;

import com.example.fzp.entity.StudySay;
import com.example.fzp.service.studySayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/studySay")
public class studySayController {
    @Resource
    studySayService studySayService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studySayService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studySayService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return studySayService.findByUserIdCode(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int studyId, @RequestParam int userId) {
        return studySayService.findByPageCode(page,limit,studyId,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody StudySay StudySay) {
        return studySayService.saveCode(StudySay);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody StudySay StudySay) {
        return studySayService.updateByIdCode(StudySay);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return studySayService.DeleteByIdCode(id);
    }
    
}
