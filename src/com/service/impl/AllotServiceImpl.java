package com.service.impl;

import com.dao.AllotDAO;
import com.entity.Allot;
import com.service.AllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("allotService")
public class AllotServiceImpl implements AllotService {
    @Autowired
    private AllotDAO allotDAO;

    @Override
    public int insertAllot(Allot allot) {
        return allotDAO.insertAllot(allot);
    }

    @Override
    public int updateAllot(Allot allot) {
        return allotDAO.updateAllot(allot);
    }

    @Override
    public int deleteAllot(String allotid) {
        return allotDAO.deleteAllot(allotid);
    }

    @Override
    public List<Allot> getAllAllot() {
        return allotDAO.getAllAllot();
    }

    @Override
    public List<Allot> getAllotByCond(Allot allot) {
        return allotDAO.getAllotByCond(allot);
    }

    @Override
    public List<Allot> getAllotByLike(Allot allot) {
        return allotDAO.getAllotByLike(allot);
    }

    @Override
    public Allot getAllotById(String allotid) {
        return   allotDAO.getAllotById(allotid);
    }
}
