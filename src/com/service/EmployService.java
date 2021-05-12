package com.service;

import com.entity.Employ;

import java.util.List;

public interface EmployService {
    //新增员工
    public int insertEmploy(Employ employ);
    //新增员工审核
    public int insertCheckEmploy(Employ employ);
    //更新员工
    public int updateEmploy(Employ employ);
    //删除员工
    public int deleteEmploy(String employid);
    //删除员工审核
    public int deleteCheckEmploy(String employid);
    //查询全部员工
    public List<Employ> getAllEmploy();
    //根据条件查询
    public List<Employ> getEmployByCond(Employ employ);
    //根据条件查询审核
    public List<Employ> getCheckEmployByCond(Employ employ);
    //模糊查询
    public List<Employ> getEmployByLike(Employ employ);
    //模糊查询审核
    public List<Employ> getCheckEmployByLike(Employ employ);
    //根据主键查询
    public Employ getEmployById(String employid);
    //根据主键查询审核
    public Employ getCheckEmployById(String employid);
}
