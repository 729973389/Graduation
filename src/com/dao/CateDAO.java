package com.dao;

import com.entity.Cate;
import org.springframework.stereotype.Repository;

import java.util.List;

//对应接口的方法
@Repository("cateDAO")
public interface CateDAO {
    //插入服务类型数据
    public int insertCate(Cate cate);
    //更新服务类型数据
    public int updateCate(Cate cate);
    //删除服务类型数据
    public int deleteCate(String cateid);
    //查询服务类型字段进行模糊查询
    public List<Cate> getCateByLike(Cate cate);
    //根据服务类型主键，查询服务类型数据
    public Cate getCateById(String cateid);

    //查询所有服务类型数据
    public List<Cate> getAllCate();

    public  List<Cate> getCateFront();
}
