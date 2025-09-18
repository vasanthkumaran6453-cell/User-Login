package com.example.User_Login.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_site_mapping")
public class UserSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "customer_site_id")
    private Integer customerSiteId;

    @Column(name = "site_name")
    private String siteName;

    public UserSite(Integer id, Integer userId, Boolean status, Integer customerSiteId, String siteName) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.customerSiteId = customerSiteId;
        this.siteName = siteName;
    }

    public UserSite() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCustomerSiteId() {
        return customerSiteId;
    }

    public void setCustomerSiteId(Integer customerSiteId) {
        this.customerSiteId = customerSiteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
