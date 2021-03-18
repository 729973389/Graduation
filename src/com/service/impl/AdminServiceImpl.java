package com.service.impl;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    //自动装配
    @Autowired
    private AdminDAO adminDAO;



    @Override
    public List<Admin> getAdminByCond(Admin admin) {
        return adminDAO.getAdminByCond(admin);
    }
    public Admin getAdminById(String adminid) {
        return adminDAO.getAdminById(adminid);
    }
    public int updateAdmin(Admin admin) {

        return adminDAO.updateAdmin(admin);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return this.adminDAO.insertAdmin(admin);
    }
    @Override
    public List<Admin> getAdminByLike(Admin admin) {
        return this.adminDAO.getAdminByLike(admin);
    }

    @Override
    public int deleteAdmin(String id) {
        return this.adminDAO.deleteAdmin(id);
    }
}
