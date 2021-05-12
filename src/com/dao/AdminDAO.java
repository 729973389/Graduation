package com.dao;

import com.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("adminDAO")//根据这个注解生成一个对象
public interface AdminDAO {
 public List<Admin> getAdminByCond(Admin admin);
 //根据主键获取管理员信息
 public Admin getAdminById(String adminid);
 //更新Admin对应的数据
 public int updateAdmin(Admin admin);
 //出入后台人员
 public int insertAdmin(Admin admin);
 //根据Admin进行模糊查询
 public List<Admin> getAdminByLike(Admin admin);
 //根据主键id删除管理人员信息
 public int deleteAdmin(String adminid);
}
