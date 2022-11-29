package com.example.fzp.controller;



import com.example.fzp.entity.SignType;
import com.example.fzp.service.SignTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/signType")
public class signTypeController {

    @Resource
    SignTypeService signTypeService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return signTypeService.findAll();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long id) {
        return signTypeService.findByIdCode(id);
    }

    @PostMapping("save")
    public Map save(@RequestBody SignType signType) {
        return signTypeService.saveCode(signType);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody SignType signType) {
        return signTypeService.updateByIdCode(signType);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return signTypeService.DeleteByIdCode(id);
    }
}
