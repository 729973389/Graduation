package com.action;

import com.entity.Orders;
import com.service.OrdersService;
import com.service.UsersService;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersAction extends BaseAction{
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UsersService usersService;

    @RequestMapping("queryOrdersByCond.action")
    public String queryOrdersByCond(String cond,String name,String number){
        Orders orders=new Orders();
        if (null!=cond){
            if ("ordercode".equals(cond)){
                orders.setOrdercode(name);
            }
            if ("usersid".equals(cond)){
                orders.setUsersid(name);
            }
            if ("total".equals(cond)){
                orders.setTotal(name);
            }
            if ("addtime".equals(cond)){
                orders.setAddtime(name);
            }
            if ("status".equals(cond)){
                orders.setStatus(name);
            }
            if ("address".equals(cond)){
                orders.setAddress(name);
            }
            if ("contact".equals(cond)){
                orders.setContact(name);
            }
            if ("workdate".equals(cond)){
                orders.setWorkdate(name);
            }
            if ("worktime".equals(cond)){
                orders.setWorktime(name);
            }
        }
        List<String> nameList=new ArrayList<String>();
        List<String> valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(ordersService.getOrdersByLike(orders),"orders",nameList,valueList,10,number,getRequest(),"query");
        return "admin/queryorders";
    }





}
