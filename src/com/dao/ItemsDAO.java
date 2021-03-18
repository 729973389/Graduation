package com.dao;

import com.entity.Items;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("itemsDAO")
public interface ItemsDAO {
    //插入服务项目订单项目列表
    public int insertItems(Items items);

    //修改服务订单项目
    public int updateItems(Items items);

    //删除服务订单项目
    public int deleteItems(String itemsid);
    //查询所有服务订单项目
    public List<Items> getAllItems();

    public List<Items> getItemsByCond(Items items);

    public List<Items> getItemsByLike(Items items);

    public Items getItemsById(String itemsid);
}
