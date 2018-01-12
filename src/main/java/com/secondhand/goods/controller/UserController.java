package com.secondhand.goods.controller;

import com.secondhand.goods.entity.Result;
import com.secondhand.goods.entity.User;
import com.secondhand.goods.repository.GoodsRepository;
import com.secondhand.goods.repository.UserRepository;
import com.secondhand.goods.service.UserService;
import com.secondhand.goods.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lokey
 * 2018/1/11
 */
@Controller
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }
    /**
     * 登录请求
     */
    @PostMapping(value = "/checkLogin")
    public Result<User> userLogin(@RequestParam String name , @RequestParam String password){
        User user = userRepository.findByName(name);
        if (user==null){
            return ResultUtil.error(100,"用户不存在");
        }else{
            if(password.equals(user.getPassword())){
                return ResultUtil.success(user);
            }else{
                return ResultUtil.error(101,"密码错误");
            }
        }
    }
    /**
     * 注册请求
     */
    @PostMapping(value = "/register")
    public Result<User> userRegister(@RequestParam String name,@RequestParam String password){
        User user = userRepository.findByName(name);
        if (user!=null){
            return ResultUtil.error(102,"该用户名已存在");
        }else {
            User user1 = new User();
            user1.setName(name);
            user1.setPassword(password);
            user1.setAdmin(false);
            user1.setAuthorized(false);
            return ResultUtil.success(userRepository.save(user1));
        }
    }

    /**
     * 修改用户的申请认证
     * @param name
     * @return
     */
    @PutMapping(value = "user/{name}")
    public User updateAuthorized(@PathVariable String name){
        User user = userRepository.findByName(name);
        user.setAuthorized(true);
        return user;
    }

    @GetMapping(value = "usersNotAuthorized")
    public List<User> getUsersNotAuthorized(){
        return userRepository.findByAuthorized(false);
    }
}
