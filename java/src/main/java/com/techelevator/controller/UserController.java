package com.techelevator.controller;



import com.techelevator.dao.UserDao;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return userDao.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody RegisterUserDto userDto) {
        return userDao.createUser(userDto);
    }
}




