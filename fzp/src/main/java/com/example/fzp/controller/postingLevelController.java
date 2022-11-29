package com.example.fzp.controller;

import com.example.fzp.entity.Opacity;
import com.example.fzp.entity.PostingLevel;
import com.example.fzp.service.opacityService;
import com.example.fzp.service.postingLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/postingLevel")
public class postingLevelController {
    @Resource
    postingLevelService postingLevelService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return postingLevelService.findAllPostingLevel();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return postingLevelService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody PostingLevel postingLevel) {
        return postingLevelService.saveCode(postingLevel);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody PostingLevel postingLevel) {
        return postingLevelService.updateByIdCode(postingLevel);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return postingLevelService.DeleteByIdCode(id);
    }
}
