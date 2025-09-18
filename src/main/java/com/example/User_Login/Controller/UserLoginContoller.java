package com.example.User_Login.Controller;

import com.example.User_Login.Model.User;
import com.example.User_Login.Model.UserCreateRequest;
import com.example.User_Login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserLoginContoller {

    @Autowired
    private UserService userService;

//    public UserLoginContoller(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/details/{userId}")

    public User getUserById(@PathVariable Integer userId) {

        return userService.getUserById(userId);
    }

     @PostMapping("/create")
     public Integer createUser(@RequestBody UserCreateRequest userCreateRequest) {
     return userService.createUser(userCreateRequest);
     }

     @DeleteMapping("/deactivate/{userId}")
    public void deleteUserById(@PathVariable Integer userId) {
        userService.deactivateUserById(userId);
     }

     @GetMapping("/name/{userName}")
    public List<User> getUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
     }

     @GetMapping("/jdbc/user/list")
    public List<User> getJdbcUserList(@RequestParam String userName) {
        return userService.getJdbcUserList(userName);
     }
}
