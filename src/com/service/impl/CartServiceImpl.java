package com.service.impl;

import com.dao.CartDAO;
import com.entity.Cart;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Override
    public int insertCart(Cart cart) {
        return cartDAO.insertCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartDAO.updateCart(cart);
    }

    @Override
    public int deleteCart(String cartid) {
        return cartDAO.deleteCart(cartid);
    }

    @Override
    public List<Cart> getAllCart() {
        return cartDAO.getAllCart();
    }

    @Override
    public List<Cart> getCartByCond(Cart cart) {
        return cartDAO.getCartByCond(cart);
    }

    @Override
    public List<Cart> getCartByLike(Cart cart) {
        return cartDAO.getCartByLike(cart);
    }

    @Override
    public Cart getCartById(String cartid) {
        return cartDAO.getCartById(cartid);
    }
}
