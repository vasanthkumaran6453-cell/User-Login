package com.example.User_Login.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "first_name")
    private String userFirstName;

    @Column(name = "last_name")
    private String userLastName;

    @Column (name = "email")
    private String email;

    @Column (name = "password")
    private String password;

    @Column (name = "mobileNo")
    private String mobileNo;

    @Column (name = "status")
    private Boolean status = true;

    public User(UserCreateRequest userCreateRequest) {
        this.userFirstName = userCreateRequest.getUserFirstName();
        this.userLastName = userCreateRequest.getUserLastName();
        this.email = userCreateRequest.getEmail();
        this.password = userCreateRequest.getPassword();
        this.mobileNo = userCreateRequest.getMobileNo();
    }

    public User() {
    super();
    }

    public User(Integer id, String userFirstName, String userLastName, String email, String password, String mobileNo, Boolean status) {
        this.id = id;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
