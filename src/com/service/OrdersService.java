package com.service;

import com.entity.Orders;

import java.util.List;

public interface OrdersService {
    //插入一个订单数据
    public int insertOrders(Orders orders);
    //更新订单数据
    public int updateOrders(Orders orders);
    //删除订单数据
    public int deleteOrders(String ordersid);
    //查看所有订单列表
    List<Orders> getAllOrders();
    //根据条件进行查询
    public List<Orders> getOrdersByCond(Orders orders);
    //模糊查询
    public List<Orders> getOrdersByLike(Orders orders);
    //根据主键查询
    public Orders getOrdersById(String ordersid);














}
