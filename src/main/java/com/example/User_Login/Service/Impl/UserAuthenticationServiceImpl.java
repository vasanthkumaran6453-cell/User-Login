package com.example.User_Login.Service.Impl;

import com.example.User_Login.Model.User;
import com.example.User_Login.Model.UserSite;
import com.example.User_Login.Repository.UserRepository;
import com.example.User_Login.Repository.UserSiteRepository;
import com.example.User_Login.ResponseDTO.UserLoginResponseDTO;
import com.example.User_Login.Service.JwtUtilService;
import com.example.User_Login.Service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtilService jwtUtilService;
    @Autowired
    private UserSiteRepository userSiteRepository;

    @Override
    public UserLoginResponseDTO userLogin(String userEmail, String userPassword) {
         User user = (User) userRepository.findByEmail(userEmail);
         if(user == null) {
             throw new RuntimeException("User not found");
         }

         if(user.getPassword().equals(userPassword)) {

             String token = jwtUtilService.generateToken(user.getEmail());

             return new UserLoginResponseDTO(
                     user.getId(),
                     user.getUserFirstName(),
                     user.getUserLastName(),
                     user.getEmail(),
                     token
             );
         } else {
             throw new RuntimeException("Invalid Credentials");
         }

    }

    public List<UserSite> getSiteDetails(Integer userId) {

        return userSiteRepository.getUserSiteByUserId(userId);
    }
}
