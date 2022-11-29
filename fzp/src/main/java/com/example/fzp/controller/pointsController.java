package com.example.fzp.controller;

import com.example.fzp.entity.Points;
import com.example.fzp.entity.Posting;
import com.example.fzp.service.pointsService;
import com.example.fzp.service.postingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController     //数据返回成JSON格式
@RequestMapping("/points")
public class pointsController {
    @Resource
    pointsService pointsService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return pointsService.findAllPoints();
    }

    @GetMapping("getAllSumPointsLimit3")
    public Map getAllSumPointsLimit3() {
        return pointsService.findAllSumPointsLimit3Code();
    }

    @GetMapping("getAllSumPointsInsLimit3")
    public Map getAllSumPointsInsLimit3() {
        return pointsService.findAllSumPointsInsLimit3Code();
    }

    @PostMapping("findById")
    public Map findById(@RequestParam Long userId) {
        return pointsService.findByIdCode(userId);
    }

    @PostMapping("findByUserId")
    public Map findByUserId(@RequestParam Long userId) {
        return pointsService.findByUserIdCode(userId);
    }

    @PostMapping("reducePoints")
    public Map reducePoints(@RequestParam Long userId,@RequestParam Long points,@RequestParam String info) {
        return pointsService.reducePointsCode(userId,points,info);
    }

    @PostMapping("findByPage")
    public Map findPointsByPage(@RequestParam int page, @RequestParam int limit,@RequestParam String name,@RequestParam String info) {
        return pointsService.findPointsByPageCode(page, limit, name, info);
    }

    @PostMapping("save")
    public Map save(@RequestBody Points points) {
        return pointsService.saveCode(points);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody Points points) {
        return pointsService.updateByIdCode(points);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return pointsService.DeleteByIdCode(id);
    }

}
