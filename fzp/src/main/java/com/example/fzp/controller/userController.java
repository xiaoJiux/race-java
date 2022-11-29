package com.example.fzp.controller;

import com.example.fzp.entity.User;
import com.example.fzp.service.userService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController     //数据返回成JSON格式
@RequestMapping("/user")
public class userController {

    @Resource
    userService userService;

    @GetMapping("getAllUser")
    public Map getAllUser() {
        return userService.findAllUser();
    }

    @PostMapping("findUserById")
    public Map findUserById(@RequestParam Long id) {
        return userService.findByIdCode(id);
    }

    @PostMapping("findUserByPage")
    public Map findUserByPage(@RequestParam int page, @RequestParam int limit, @RequestParam String number, @RequestParam String name,@RequestParam String mail,@RequestParam int sexId,@RequestParam int instituteId,@RequestParam int levelId) {
        return userService.findUserByPages(page, limit, number,name,mail,sexId,instituteId,levelId);
    }

    @PostMapping("findUserByName")
    public Map findUserByName(@RequestParam String name) {
        return userService.findUserByNames(name);
    }

    @PostMapping("findUserByNameAndPassword")
    public Map findUserByNameAndPassword(@RequestParam String numID, @RequestParam String password) {
        return userService.findUserByNameAndPasswordAndToken(numID, password);
    }

    @PostMapping("save")
    public Map save(@RequestBody User user) {
        return userService.saveCode(user);
    }

    @PostMapping("updateById")
    public Map updateById(@RequestBody User user) {
        return userService.updateByIdCode(user);
    }

    @PostMapping("DeleteById")
    public Map DeleteById(Long id) {
        return userService.DeleteByIdCode(id);
    }
}
