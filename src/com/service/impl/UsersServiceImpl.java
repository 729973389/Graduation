package com.service.impl;

import com.dao.UsersDAO;
import com.entity.Users;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDAO usersDAO;

    @Override
    public int insertUsers(Users users) {
        return usersDAO.insertUsers(users);
    }

    @Override
    public int updateUsers(Users users) {
        return usersDAO.updateUsers(users);
    }

    @Override
    public int deleteUsers(String usersid) {
        return usersDAO.deleteUsers(usersid);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    public List<Users> getUsersByLike(Users users) {
        return usersDAO.getUsersByLike(users);
    }

    @Override
    public Users getUsersById(String usersid) {
        return usersDAO.getUsersById(usersid);
    }

    @Override
    public List<Users> getUsersByCond(Users users) {
        return usersDAO.getUsersByCond(users);
    }
}
