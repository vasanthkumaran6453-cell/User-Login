package com.example.User_Login.Service;

import com.example.User_Login.Exception.UserNotFoundException;
import com.example.User_Login.Model.User;
import com.example.User_Login.Model.UserCreateRequest;
import com.example.User_Login.Repository.UserJDBCRepository;
import com.example.User_Login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private UserJDBCRepository userJDBCRepository;
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User getUserById(Integer userId)
    {
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));
    }

    public Integer createUser(UserCreateRequest userCreateRequest)
    {
        User userSave = new User(userCreateRequest);
        User savedUser = userRepository.save(userSave);
        return savedUser.getId();
    }

    public void deactivateUserById(Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        User userDelete = user.get();
        userDelete.setStatus(false);
        userRepository.save(userDelete);  //soft delete
//        userRepository.deleteById(userId);  //hard delete
    }

    public List<User> getUserByName(String name)
    {
        return userRepository.getUserByUserFirstNameContainingIgnoreCase(name);
    }

    public List<User> getJdbcUserList(String userName) {
        return userJDBCRepository.getJdbcUserList(userName);
    }
}
