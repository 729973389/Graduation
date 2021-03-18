package com.service.impl;

import com.dao.ItemsDAO;
import com.entity.Items;
import com.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDAO itemsDAO;

    @Override
    public int insertItems(Items items) {
        return itemsDAO.insertItems(items);
    }

    @Override
    public int updateItems(Items items) {
        return itemsDAO.updateItems(items);
    }

    @Override
    public int deleteItems(String itemsid) {
        return itemsDAO.deleteItems(itemsid);
    }

    @Override
    public List<Items> getAllItems() {
        return itemsDAO.getAllItems();
    }

    @Override
    public List<Items> getItemsByCond(Items items) {
        return itemsDAO.getItemsByCond(items);
    }

    @Override
    public List<Items> getItemsByLike(Items items) {
        return itemsDAO.getItemsByLike(items);
    }

    @Override
    public Items getItemsById(String itemsid) {
        return itemsDAO.getItemsById(itemsid);
    }
}
