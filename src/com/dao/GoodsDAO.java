package com.dao;

import com.entity.Goods;
import com.service.GoodsService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("/goodsDAO")
public interface GoodsDAO {
    //插入服务项目数据
    public int insertGoods(Goods goods);
    //更新服务项目数据
    public int updateGoods(Goods goods);
    //删除服务项目数据
    public int deleteGoods(String goodsid);
    //根据Goods条件进行模糊查询
    public List<Goods> getGoodsByLike(Goods goods);
    //按照主键查找服务项目
    public Goods getGoodsById(String goodsid);

    public List<Goods> getGoodsByCate(String cateid);

    public List<Goods> getGoodsByHot();


    public List<Goods> getAllGoods();
    // 按照Goods类里面的字段名称精确查询 调用goodsDAO里的getGoodsByCond配置
    public List<Goods> getGoodsByCond(Goods goods);
}
