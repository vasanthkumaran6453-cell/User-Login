package com.example.User_Login.Controller;

import com.example.User_Login.Model.UserSite;
import com.example.User_Login.ResponseDTO.UserLoginResponseDTO;
import com.example.User_Login.Service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/authenticate")
public class UserAuthenticationController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @PostMapping("/login")
    public UserLoginResponseDTO userLogin(@RequestParam String userEmail, String userPassword) {

        return userAuthenticationService.userLogin(userEmail, userPassword);
    }

    @GetMapping("/site/details/{userId}")
    public List<UserSite> siteDetails(@PathVariable Integer userId) {
        return userAuthenticationService.getSiteDetails(userId);
    }
}
