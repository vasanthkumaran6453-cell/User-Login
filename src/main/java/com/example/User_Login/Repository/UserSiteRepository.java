package com.example.User_Login.Repository;

import com.example.User_Login.Model.UserSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSiteRepository extends JpaRepository<UserSite ,Integer> {

    List<UserSite> getUserSiteByUserId(int userId);

}
