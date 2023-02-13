package com.example.registration.Dao;

import com.example.registration.Entity.Role;
import com.example.registration.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
