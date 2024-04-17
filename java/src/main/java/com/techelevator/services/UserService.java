package com.techelevator.services;

import com.techelevator.dao.UserDao;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
    public List<User> getAllUsers(){
        return userDao.getUsers();
    }
    public User getUserById(int userId){
        return userDao.getUserById(userId);
    }
    public void createUser(RegisterUserDto user){
        userDao.createUser(null);
    }
    public void deleteUser(int userId){
        userDao.delete(userId);
    }
}
