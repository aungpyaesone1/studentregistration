package com.example.registration.Service.Impl;

import com.example.registration.Dao.RoleDao;
import com.example.registration.Dao.UserDao;
import com.example.registration.Dto.*;
import com.example.registration.Entity.Role;
import com.example.registration.Entity.User;
import com.example.registration.Service.SiginService;
import com.example.registration.Util.GeneralUtil;
import com.example.registration.Util.JWTUtil;
import com.example.registration.Util.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SiginServiceImpl implements SiginService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private RoleDao roleDao;

    @Override
    public BaseResponse register(RegisterData registerData) {
        User user = new User();
        BaseResponse response = new BaseResponse();
        user.setSyskey(GeneralUtil.getUintNumber());
        user.setUserid(registerData.getUserid());
        user.setUsername(registerData.getUsername());
        user.setPassword(registerData.getPassword());
        user.setModifieddate(new Date().toString());
        user.setCreateddate(new Date().toString());
        Set<Role> roles = new HashSet<>();
        for(String role : registerData.getRoles()){
            Role res_data = roleDao.findByName(role).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(res_data);
        }
        user.setRoles(roles);
        User res = userDao.save(user);
        if(res.getSyskey() > 0){
            response.setSyskey(res.getSyskey());
            response.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
            response.setStatus_message(ResponseEnum.ResponseMessage.SAVE_SUCCESS.message());
        }
        return response;
    }

    @Override
    public SiginResponse sigin(SiginData siginData) {
        SiginResponse siginResponse= userDao.findByUserIdAndPassword(siginData.getUserid(), siginData.getPassword());
        siginResponse.setToken(jwtUtil.generateJwtToken(siginData.getUserid()));
        return siginResponse;
    }
}
