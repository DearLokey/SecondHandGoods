package com.secondhand.goods.controller;

import com.secondhand.goods.entity.Goods;
import com.secondhand.goods.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lokey
 * 2018/1/12
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping(value = "goods")
    public void getGoods(){
        goodsRepository.findAll();
    }

    @PostMapping(value = "addGoods")
    public void addGoods(Goods goods){
        goodsRepository.save(goods);
    }
}
