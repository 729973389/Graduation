package com.dao;

import com.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usersDAO")
public interface UsersDAO {
    //插入用户数据
    public int insertUsers(Users users);
    //更新用户数据
    public int updateUsers(Users users);
    //删除用户数据
    public int deleteUsers(String usersid);
    //查询全部用户数据
    public List<Users> getAllUsers();
    //模糊查询
    public List<Users> getUsersByLike(Users users);
    //根据主键查询用户
    public Users getUsersById(String usersid);

    public List<Users> getUsersByCond(Users users);
}
