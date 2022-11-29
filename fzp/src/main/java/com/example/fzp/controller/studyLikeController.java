package com.example.fzp.controller;

import com.example.fzp.entity.HeadlinesLike;
import com.example.fzp.entity.StudyLike;
import com.example.fzp.service.headlinesLikeService;
import com.example.fzp.service.studyLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/studyLike")
public class studyLikeController {
    @Resource
    studyLikeService studyLikeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return studyLikeService.findAllCode();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return studyLikeService.findByIdCode(id);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return studyLikeService.findByLikeTypeId(userId);
    }

    @PostMapping("findByPage")
    public Map findByPage(@RequestParam int page, @RequestParam int limit, @RequestParam int studyId, @RequestParam int likeType, @RequestParam int userId) {
        return studyLikeService.findByPageCode(page,limit,studyId,likeType,userId);
    }

    @PostMapping("save")
    public Map save(@RequestBody StudyLike studyLike) {
        return studyLikeService.saveCode(studyLike);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody StudyLike studyLike) {
        return studyLikeService.updateByIdCode(studyLike);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return studyLikeService.DeleteByIdCode(id);
    }
}
