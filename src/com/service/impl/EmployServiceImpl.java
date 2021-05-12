package com.service.impl;

import com.dao.EmployDAO;
import com.entity.Employ;
import com.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employService")
public class EmployServiceImpl implements EmployService {
    @Autowired
    private EmployDAO employDAO;

    @Override
    public int insertEmploy(Employ employ) {
        return employDAO.insertEmploy(employ);
    }

    @Override
    public int insertCheckEmploy(Employ employ) {
        return employDAO.insertCheckEmploy(employ);
    }

    @Override
    public int updateEmploy(Employ employ) {
        return employDAO.updateEmploy(employ);
    }

    @Override
    public int deleteEmploy(String employid) {
        return employDAO.deleteEmploy(employid);
    }

    @Override
    public int deleteCheckEmploy(String employid) {
        return employDAO.deleteCheckEmploy(employid);
    }

    @Override
    public List<Employ> getAllEmploy() {
        return employDAO.getAllEmploy();
    }

    @Override
    public List<Employ> getEmployByCond(Employ employ) {
        return employDAO.getEmployByCond(employ);
    }

    @Override
    public List<Employ> getCheckEmployByCond(Employ employ) {
        return employDAO.getCheckEmployByCond(employ);
    }

    @Override
    public List<Employ> getCheckEmployByLike(Employ employ) {
        return employDAO.getCheckEmployByLike(employ);
    }

    @Override
    public List<Employ> getEmployByLike(Employ employ) {
        return employDAO.getEmployByLike(employ);
    }

    @Override
    public Employ getEmployById(String employid) {
        return employDAO.getEmployById(employid);
    }

    @Override
    public Employ getCheckEmployById(String employid) {
        return employDAO.getCheckEmployById(employid);
    }
}
