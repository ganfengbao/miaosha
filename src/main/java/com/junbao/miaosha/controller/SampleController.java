package com.junbao.miaosha.controller;

import com.junbao.miaosha.domain.User;
import com.junbao.miaosha.redis.UserKey;
import com.junbao.miaosha.service.RedisService;
import com.junbao.miaosha.service.UserService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 小笨蛋
 */
@Controller
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name","Jack");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/db/get")
    public User doGet(Model model) {
        User user = userService.getById(1);
        return user;
    }

    @ResponseBody
    @RequestMapping("/db/tx")
    public boolean doTx() {
        userService.tx();
        return true;
    }

    @ResponseBody
    @RequestMapping("/redis/get")
    public User redisGet() {
        User user = redisService.get(UserKey.getById,"1", User.class);
        return user;
    }

    @ResponseBody
    @RequestMapping("/redis/set")
    public User redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("hf");
        boolean ret = redisService.set(UserKey.getById, "1", user);
        User v1 = redisService.get(UserKey.getById, "1", User.class);
        return user;
    }
}
