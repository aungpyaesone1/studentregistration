package com.example.registration.Service;

import com.example.registration.Dto.*;

public interface SiginService {
    public BaseResponse register(RegisterData registerData);

    public SiginResponse sigin(SiginData siginData);
}
