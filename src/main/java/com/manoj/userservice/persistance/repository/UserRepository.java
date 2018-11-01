package com.manoj.userservice.persistance.repository;

import com.manoj.userservice.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

  User findByUsername(String userName);

}
