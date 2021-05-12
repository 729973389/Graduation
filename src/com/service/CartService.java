package com.service;

import com.entity.Cart;

import java.util.List;

public interface CartService {
    //新增购物车数据
    public int insertCart(Cart cart);
    //更新购物车数据
    public int updateCart(Cart cart);
    //删除购物车数据
    public int deleteCart(String cartid);

    public List<Cart> getAllCart();

    public List<Cart> getCartByCond(Cart cart);

    public List<Cart> getCartByLike(Cart cart);

    public Cart getCartById(String cartid);
}
