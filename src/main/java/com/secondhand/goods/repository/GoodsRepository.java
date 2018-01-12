package com.secondhand.goods.repository;

import com.secondhand.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lokey
 * 2018/1/12
 */
public interface GoodsRepository extends JpaRepository<Goods,Integer>{
    public Goods findByName(String name);
}
