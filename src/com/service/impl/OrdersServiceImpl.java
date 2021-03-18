package com.service.impl;

import com.dao.OrdersDAO;
import com.entity.Orders;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDAO ordersDAO;
    @Override
    public int insertOrders(Orders orders) {
        return ordersDAO.insertOrders(orders);
    }

    @Override
    public int updateOrders(Orders orders) {
        return ordersDAO.updateOrders(orders);
    }

    @Override
    public int deleteOrders(String ordersid) {
        return ordersDAO.deleteOrders(ordersid);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersDAO.getAllOrders();
    }

    @Override
    public List<Orders> getOrdersByCond(Orders orders) {
        return ordersDAO.getOrdersByCond(orders);
    }

    @Override
    public List<Orders> getOrdersByLike(Orders orders) {
        return ordersDAO.getOrdersByLike(orders);
    }

    @Override
    public Orders getOrdersById(String ordersid) {
        return ordersDAO.getOrdersById(ordersid);
    }
}
