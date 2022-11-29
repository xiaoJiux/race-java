package com.example.fzp.controller;


import com.example.fzp.entity.StudyType;
import com.example.fzp.service.studyTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/studyType")
public class studyTypeController {
    @Resource
    studyTypeService studyTypeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studyTypeService.findAllStudyType();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studyTypeService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody StudyType studyType) {
        return studyTypeService.saveCode(studyType);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody StudyType studyType) {
        return studyTypeService.updateByIdCode(studyType);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(@RequestParam Long id) {
        return studyTypeService.DeleteByIdCode(id);
    }

}
