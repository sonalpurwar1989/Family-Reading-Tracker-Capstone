package com.techelevator.controller;



import com.techelevator.dao.UserDao;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import com.techelevator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
}

   /* @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody RegisterUserDto userDto) {
        return userService.createUser(userDto);
    }
}

*/


