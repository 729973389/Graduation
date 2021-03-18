package com.service;

import com.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("adminService")
public interface AdminService {
    //根据Admin中的字段名称精确查询admin信息
    public List<Admin> getAdminByCond(Admin admin);
    //根据逐渐获取管理员信息
    public Admin getAdminById(String adminid);
    //更新Admin对应的数据
    public int updateAdmin(Admin admin);
    //插入后台人员
    public int insertAdmin(Admin admin);
    //根据页面输入条件进行模糊查询
    public List<Admin> getAdminByLike(Admin admin);
    //根据主键id删除管理人员信息
    public int deleteAdmin(String id);

}
