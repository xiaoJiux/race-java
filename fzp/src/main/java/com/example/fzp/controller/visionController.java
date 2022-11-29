package com.example.fzp.controller;

import com.example.fzp.entity.Study;
import com.example.fzp.service.studySayService;
import com.example.fzp.service.studyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/vision")
public class visionController {
    @Resource
    studyService studyService;

    @Resource
    studySayService studySayService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studyService.findAllVisionCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studyService.findByVisionIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody Study study) {
        return studyService.saveEyes(study);
    }

    @GetMapping("findVisionSayAll")
    public Map findVisionSayAll() {
        return studySayService.findVisionAll();
    }


    @PostMapping("findByVisionSayUserId")
    public Map findByVisionSayUserId(@RequestParam Long userId) {
        return studySayService.findByVisionUserId(userId);
    }

    @PostMapping("findByVisionSayId")
    public Map findByVisionSayId(@RequestParam Long id) {
        return studySayService.findByVisionId(id);
    }

    @PostMapping("findByVisionSayVisionId")
    public Map findByVisionSayVisionId(@RequestParam Long visionId) {
        return studySayService.findByVisionSayVisionId(visionId);
    }

    @PostMapping("findByVisionUserId")
    public Map findByVisionUserId(@RequestParam Long userId) {
        return studyService.findByVisionUserIdCode(userId);
    }


}
