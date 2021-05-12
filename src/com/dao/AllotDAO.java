package com.dao;

import com.entity.Allot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("allotDAO")
public interface AllotDAO {
    //插入数据
    public int insertAllot(Allot allot);
    //更新数据
    public int updateAllot(Allot allot);
    //删除数据
    public int deleteAllot(String allotid);
    //查询所有分配
    public List<Allot> getAllAllot();
    //根据条件查询分配
    public List<Allot> getAllotByCond(Allot allot);
    //模糊查询
    public List<Allot> getAllotByLike(Allot allot);
    //根据主键查询分配信息
    public Allot getAllotById(String allotid);
}
