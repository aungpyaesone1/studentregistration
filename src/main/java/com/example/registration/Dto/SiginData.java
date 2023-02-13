package com.example.registration.Dto;

public class SiginData {
    private Long syskey;
    private String userid;
    private String password;

    public SiginData(Long syskey, String userid, String password) {
        this.syskey = syskey;
        this.userid = userid;
        this.password = password;
    }

    public Long getSyskey() {
        return syskey;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
