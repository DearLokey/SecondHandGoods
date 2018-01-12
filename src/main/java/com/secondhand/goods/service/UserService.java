package com.secondhand.goods.service;

import com.secondhand.goods.entity.Result;
import com.secondhand.goods.entity.User;
import com.secondhand.goods.repository.UserRepository;
import com.secondhand.goods.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by lokey
 * 2018/1/11
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;




}
