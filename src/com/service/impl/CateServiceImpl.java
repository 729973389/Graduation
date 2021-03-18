package com.service.impl;

import com.dao.CateDAO;
import com.entity.Cate;
import com.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("cateService")
public class CateServiceImpl implements CateService {
    @Autowired
    private CateDAO cateDAO;
    @Override
    public int insertCate(Cate cate) {
        return cateDAO.insertCate(cate);
    }

    @Override
    public int updateCate(Cate cate) {
        return cateDAO.updateCate(cate);
    }

    @Override
    public int deleteCate(String cateid) {
        return cateDAO.deleteCate(cateid);
    }

    @Override
    public List<Cate> getCateByLike(Cate cate) {
        return cateDAO.getCateByLike(cate);
    }

    @Override
    public Cate getCateById(String cateid) {
        return cateDAO.getCateById(cateid);
    }
    //查询所有服务类型数据
    @Override
    public List<Cate> getAllCate() {
        return this.cateDAO.getAllCate();
    }


    @Override
    public List<Cate> getCateFront() {
        return this.cateDAO.getCateFront();
    }
}
