package com.example.fzp.controller;

import com.example.fzp.entity.Study;
import com.example.fzp.entity.User;
import com.example.fzp.service.studyService;
import com.example.fzp.service.userService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController     //数据返回成JSON格式
@RequestMapping("/study")
public class studyController {

    @Resource
    studyService studyService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studyService.findAllStudy();
    }

    @GetMapping("getAllUserOR")
    public Map getAllUserOR() {
        return studyService.findAllStudyOR();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studyService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return studyService.findByUserIdCode(userId);
    }



    @PostMapping("findBySayData")
    public Map findBySayData(Long studyId) {
        return studyService.studySayData(studyId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam String name, @RequestParam String location,@RequestParam int studyType,@RequestParam int userId) {
        return studyService.findPostingByPageCode(page,limit,name,location,studyType,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody Study study) {
        return studyService.saveCode(study);
    }

    @PostMapping("saveEyes")
    public Map saveEyes(@RequestBody Study study) {
        return studyService.saveEyes(study);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Study study) {
        return studyService.updateByIdCode(study);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return studyService.DeleteByIdCode(id);
    }

}
