package com.example.User_Login.Service;

import com.example.User_Login.Model.UserSite;
import com.example.User_Login.ResponseDTO.UserLoginResponseDTO;

import java.util.List;

public interface UserAuthenticationService {
    public UserLoginResponseDTO userLogin(String userEmail, String userPassword);

    public List<UserSite> getSiteDetails(Integer userId);

}
