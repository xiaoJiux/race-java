package com.example.fzp.controller;

import com.example.fzp.entity.Study;
import com.example.fzp.service.studySayService;
import com.example.fzp.service.studyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/tiktok")
public class tiktokController {

    @Resource
    studyService studyService;

    @Resource
    studySayService studySayService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studyService.findAllTiktokCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studyService.findByTiktokIdCode(id);
    }

    @PostMapping("saveTiktok")
    public Map save(@RequestBody Study study) {
        return studyService.saveTiktok(study);
    }

    @GetMapping("findVisionSayAll")
    public Map findVisionSayAll() {
        return studySayService.findTiktokAll();
    }


    @PostMapping("findByVisionSayUserId")
    public Map findByVisionSayUserId(@RequestParam Long userId) {
        return studySayService.findByTiktokUserId(userId);
    }

    @PostMapping("findByVisionSayId")
    public Map findByVisionSayId(@RequestParam Long id) {
        return studySayService.findByTiktokId(id);
    }

    @PostMapping("findByVisionSayVisionId")
    public Map findByVisionSayVisionId(@RequestParam Long tiktokId) {
        return studySayService.findByTiktokSayTiktokId(tiktokId);
    }

    @PostMapping("findByVisionUserId")
    public Map findByVisionUserId(@RequestParam Long userId) {
        return studyService.findByTiktokUserIdCode(userId);
    }

}
