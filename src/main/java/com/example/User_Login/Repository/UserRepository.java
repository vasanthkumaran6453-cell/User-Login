package com.example.User_Login.Repository;

import com.example.User_Login.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUserByUserFirstNameContainingIgnoreCase(String userFirstName);

    @Query("SELECT u FROM User u WHERE UPPER(u.userFirstName) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<User> findByFirstNameLike(@Param("keyword") String keyword);

    Object findByEmail(String email);

}
