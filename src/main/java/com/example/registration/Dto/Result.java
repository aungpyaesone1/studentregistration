package com.example.registration.Dto;

public class Result<T> extends BaseResponse{
    private T data;
    public Result(T t){
        this.data = t;
    }
}
