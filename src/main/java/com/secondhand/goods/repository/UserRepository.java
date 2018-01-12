package com.secondhand.goods.repository;

import com.secondhand.goods.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lokey
 * 2018/1/11
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    //根据用户名查找用户信息
    public User findByName(String name);

    public List<User> findByAuthorized(boolean authorized);
}
