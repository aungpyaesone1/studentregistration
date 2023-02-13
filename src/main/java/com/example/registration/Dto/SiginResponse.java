package com.example.registration.Dto;

public class SiginResponse extends BaseResponse{
    private String token;
    private String userid;
    private String username;
    public SiginResponse(long syskey, String userid, String username){
        this.userid = userid;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
