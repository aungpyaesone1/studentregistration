package com.example.registration.Dao;

import com.example.registration.Dto.SiginData;
import com.example.registration.Dto.SiginResponse;
import com.example.registration.Dto.StudentDto;
import com.example.registration.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String userId);
    Boolean existsByUsername(String username);
    @Query("select new com.example.registration.Dto.SiginResponse (syskey,userid,username) from User where userid=:userid and password=:password")
    SiginResponse findByUserIdAndPassword(String userid, String password);
}
