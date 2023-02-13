package com.example.registration.Dto;

import java.util.List;

public class UserPrinciple {
    private Long syskey;
    private String userid;
    private String username;
    private List<String> roles;

    public Long getSyskey() {
        return syskey;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setSyskey(Long syskey) {
        this.syskey = syskey;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
