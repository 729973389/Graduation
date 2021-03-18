package com.action;

import com.entity.Items;
import com.service.ItemsService;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsAction extends BaseAction{
    @Autowired
    private ItemsService itemsService;

    //查询订单服务明细
    @RequestMapping("queryItemsByCond.action")
    public String queryItemsByCond(String cond,String name,String number){
        Items items=new Items();
        if (null!=cond){
            if ("ordercode".equals(cond)) {
                items.setOrdercode(name);
            }
            if ("goodsname".equals(cond)) {
                items.setGoodsname(name);
            }
            if ("price".equals(cond)) {
                items.setPrice(name);
            }
        }
        List<String> nameList=new ArrayList<String>();
        List<String> valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(itemsService.getItemsByLike(items),"items",nameList,valueList,10,number,getRequest(),"query");
        return "admin/queryitems";
    }
}
