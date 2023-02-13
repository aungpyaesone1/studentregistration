package com.example.registration.Dto;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

public class BaseResponse {
    private String status_code;
    private String status_message;
    private long syskey;
    private Map data;

    public BaseResponse(){

    }

    public BaseResponse(String status_code, String status_message) {
        this.status_code = status_code;
        this.status_message = status_message;
    }

    public long getSyskey() {
        return syskey;
    }

    public void setSyskey(long syskey) {
        this.syskey = syskey;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }
}
