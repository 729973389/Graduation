package com.service.impl;

import com.dao.GoodsDAO;
import com.entity.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsSerVice")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    public int insertGoods(Goods goods) {
        return goodsDAO.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDAO.updateGoods(goods);
    }

    @Override
    public int deleteGoods(String goodsid) {
        return goodsDAO.deleteGoods(goodsid);
    }

    @Override
    public List<Goods> getGoodsByLike(Goods goods) {
        return goodsDAO.getGoodsByLike(goods);
    }

    @Override
    public Goods getGoodsById(String goodsid) {
        return goodsDAO.getGoodsById(goodsid);
    }

    @Override
    public List<Goods> getGoodsByCate(String cateid) {
        return goodsDAO.getGoodsByCate(cateid);
    }

    @Override
    public List<Goods> getGoodsByHot() {
        return goodsDAO.getGoodsByHot();
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDAO.getAllGoods();
    }

    @Override
    public List<Goods> getGoodsByCond(Goods goods) {
        return goodsDAO.getGoodsByCond(goods);
    }
}
